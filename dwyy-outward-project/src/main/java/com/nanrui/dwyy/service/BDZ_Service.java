package com.nanrui.dwyy.service;

import com.alibaba.fastjson.JSONObject;
import com.nanrui.dwyy.DwyyApplication;
import com.nanrui.dwyy.bean.*;
import com.nanrui.dwyy.repository.*;
import com.nanrui.dwyy.utils.JsonUtils;
import com.nanrui.dwyy.utils.ReadExcel;
import com.nanrui.dwyy.utils.TestDataUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class BDZ_Service {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    GS_BDZ_Repository gs_bdz_repository;

    @Autowired
    BDZ_Coord_Repository bdz_coord_repository;

    @Autowired
    BDZ_Relationship_Message_Repository bdz_relationship_message_repository;

    @Autowired
    City_Message_Repository city_message_repository;

    @Autowired
    BDZ_Message_Repository bdz_message_repository;

    City_Message city_message = null;

    List<City_Message> cityMessageList = new ArrayList<>();

    List<LineData_Message> lineData_messageList = new ArrayList<>();

    /**
     * 由于为测试，因此数据来源为表格，之后的来源会是数据库
     * @return
     */
    public Map<String,Object> readSourceData(String cityname,String condition){
        Map<String,Object> htmlData = new HashMap<>();
        boolean result = false;
        try {
            /**
             * condition    前端传入电压等级为110KV，需要转换为数据库中规定的命名
             */
            condition = condition_Dispose(condition);

            /**
             * 制造假数据:
             *          变电站关系数据_甘肃
             *          35kV及以上变电站(2)
             *
             *正式环境可删除
             */
            long count_gs = gs_bdz_repository.count();
            long count_bdz_coord = bdz_coord_repository.count();
            if (0 == count_gs || 0 == count_bdz_coord){
                result = true;
            }
            readExcel_disposeData(result);
            /**
             * 制作变电站信息表，假数据，将现有甘肃的所有变电站信息查询入库，包括起始变电站和终点变电站
             * SELECT a.name_start,a.city_code,b.x_coord,b.y_coord
             * FROM substation_particulars_gs a,substation_particulars b WHERE a.pms_id_start = b.sbid
             */
            long count_bdz_Message = bdz_message_repository.count();
            if (0 == count_bdz_Message){
                List<Object[]> objects_start = bdz_message_repository.selectBDZ_Message_startId();
                List<Object[]> objects_end = bdz_message_repository.selectBDZ_Message_endId();
                List<BDZ_Message> bdz_messageList = new ArrayList<>();
                TestDataUtils dataUtils = new TestDataUtils();
                bdz_messageList.addAll(dataUtils.dataDispose(objects_start));
                bdz_messageList.addAll(dataUtils.dataDispose(objects_end));
                bdz_message_repository.saveAll(bdz_messageList);
            }

            /**
             * 制作变电站关系表
             * @Query(value = "SELECT pms_id_start,dtdj_start,name_start,pms_id_end,dydj_end,name_end,city,city_code
             * FROM substation_particulars_gs where city_code = ?1")
             *     public List<Object[]> getBDZ_Message(String cityCode);
             *
             *     @Query(value = "SELECT x_coord,y_coord FROM substation_particulars WHERE sbid LIKE ?1")
             *     public List<Object[]> getBDZCoord_Message(String bdzID);
             */
            long count = bdz_relationship_message_repository.count();
            if (0 == count){
                List<Object[]> bdz_message = new ArrayList<>();
                if (null == condition){
                    if ("china".equals(cityname)){
                        bdz_message = bdz_relationship_message_repository.getBDZ_Message();
                    }else {
                        bdz_message = bdz_relationship_message_repository.getBDZ_Message_city(cityname);
                    }
                }else{
                    if ("china".equals(cityname)){
                        bdz_message = bdz_relationship_message_repository.getBDZ_Message_condition(condition);
                    }else {
                        bdz_message = bdz_relationship_message_repository.getBDZ_Message(cityname,condition);
                    }
                }

                List<BDZ_Relationship_Message> bdz_relationship_messages = bdzRelationshipMessages(bdz_message);
                bdz_relationship_message_repository.saveAll(bdz_relationship_messages);
            }
            /**
             * =============================================================
             * 数据制作完成，开始查询数据封装数据
             */
            //读取json文件，获取其中城市坐标
            /**
             * 获取城市信息--表City_Message
             *      为页面描点做准备
             * 读取json数据
             *          网省地市坐标
             */
            long count_city_message = city_message_repository.count();
            List<Object[]> city_message_html = new ArrayList<>();
            if (0 == count_city_message){
                List<City_Message> city_message = findCity_Message();
                city_message_repository.saveAll(city_message);
            } else{
                city_message_html = findCity_Message_Html(cityname);
            }




            /**
             * 里面包括页面描点的所有数据
             *      包括：所有变电站信息和所有网省城市地理坐标信息
             */
            List<Object[]> bdz_messageForHtml = new ArrayList<>();
            if (null == condition){
                if ("china".equals(cityname)){
                    bdz_messageForHtml = bdz_relationship_message_repository.getBDZ_MessageForHtml();
                }else {
                    bdz_messageForHtml = bdz_relationship_message_repository.getBDZ_MessageForHtml_city(cityname);
                }
            } else {
                if ("china".equals(cityname)){
                    bdz_messageForHtml =bdz_relationship_message_repository.getBDZ_MessageForHtml_condition(condition);
                }else {
                    bdz_messageForHtml = bdz_relationship_message_repository.getBDZ_MessageForHtml(cityname,condition);
                }
            }
            List<LineData_Message> lineDataMessageList = new ArrayList<>();
            List<PointData_Message> pointDataMessageList = new ArrayList<>();
            for (int i = 0; i < bdz_messageForHtml.size(); i++) {
                Object[] objects = bdz_messageForHtml.get(i);
                LineData_Message lineData = getLineData_messageList(objects);
                int con = 0;
                for (int j = 0; j<2;j++){
                    PointData_Message pointData = getPointData_messageList(objects,con);
                    /**
                     * 电压等级进行处理
                     */
                    pointData.setDydj(dydj_Dispose(pointData.getDydj()));
                    pointDataMessageList.add(pointData);
                    con ++;
                }
                lineDataMessageList.add(lineData);
            }

            htmlData.put("lineDataMessageList",lineDataMessageList);
            htmlData.put("pointDataMessageList",pointDataMessageList);
            htmlData.put("city_message_html",city_message_html);
            //htmlData.put("cityMessage",cityMessage);
            return htmlData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String condition_Dispose(String condition){
        String condition_DisStr = "";
        if (null == condition){
            condition_DisStr = null;
            return condition_DisStr;
        }else {
            switch (condition){
                case "1000KV":
                    condition_DisStr = "AC10001";
                    break;
                case "750KV":
                    condition_DisStr = "AC07501";
                    break;
                case "500KV":
                    condition_DisStr = "AC05001";
                    break;
                case "350KV":
                    condition_DisStr = "AC03501";
                    break;
                case "330KV":
                    condition_DisStr = "AC03301";
                    break;
                case "220KV":
                    condition_DisStr = "AC02201";
                    break;
                case "110KV":
                    condition_DisStr = "AC01101";
                    break;
                case "66KV":
                    condition_DisStr = "AC00661";
                    break;
                case "35KV":
                    condition_DisStr = "AC00351";
                    break;
                default:
                    condition_DisStr = null;
                    break;
            }
            return condition_DisStr;
        }

        /*String condition_DisStr = "";
        String condition_kv = condition.replaceAll("KV", "");*/

    }

    public String dydj_Dispose(String str){
        String dydj = "";
        if (str.substring(3,4).equals("0")){
            dydj = str.substring(4,6);
            return dydj;
        }else{
            dydj = str.substring(3,6);
            return dydj;
        }
    }

    public LineData_Message getLineData_messageList(Object[] bean){
        String pms_id_start = bean[7].toString();
        String pms_id_end = bean[6].toString();
        String dtdj_start = bean[2].toString();
        String dydj_end = bean[3].toString();
        String fromName = bean[5].toString();
        String toName = bean[4].toString();
        Integer state = 0;
        LineData_Message beanLine = new LineData_Message(
                pms_id_start,pms_id_end,dtdj_start,dydj_end,fromName,toName,state
        );
        return beanLine;
    }

    /**
     *  @Query(value = "SELECT city,city_code,dtdj_start,dydj_end,name_end,name_start," +
     *             "pms_id_end,pms_id_start,x_coord_end,x_coord_start,y_coord_end,y_coord_start " +
     *             "FROM substation_particulars_bdz_message WHERE city_code LIKE ?1")
     *     public List<Object[]> getBDZ_MessageForHtml(String cityname);
     * @param objects
     * @param con
     * @return
     */
    public PointData_Message getPointData_messageList(Object[] objects,int con){
        PointData_Message beanPoint = null;

        if (0 == con){
            String pms_id = objects[7].toString();
            String name = objects[5].toString();
            Double x_coord = Double.parseDouble(objects[9].toString());
            Double y_coord = Double.parseDouble(objects[11].toString());
            String dydj = objects[2].toString();
            beanPoint = new PointData_Message(
                    pms_id,name,x_coord,y_coord,dydj
            );
            return beanPoint;
        } else{
            String pms_id = objects[6].toString();
            String name = objects[4].toString();
            Double x_coord = Double.parseDouble(objects[8].toString());
            Double y_coord = Double.parseDouble(objects[10].toString());
            String dydj = objects[3].toString();
            beanPoint = new PointData_Message(
                    pms_id,name,x_coord,y_coord,dydj
            );
            return beanPoint;
        }
    }

    /**
     * 查询现有变电站关系，根据变电站关系找到对应的起始变电站X，Y及终点变电站X，Y
     * @param bdz_message
     * @return
     */
    public List<BDZ_Relationship_Message> bdzRelationshipMessages(List<Object[]> bdz_message){
        List<BDZ_Relationship_Message> bdz_relationship_messages = new ArrayList<>();
        for (int i = 0; i < bdz_message.size(); i++) {
            Object[] objects = bdz_message.get(i);
            String pms_id_start = (String) objects[0];
            String dydj_start = (String) objects[1];
            String name_start = (String) objects[2];
            String pms_id_end = (String) objects[3];
            String dydj_end = (String) objects[4];
            String name_end = (String) objects[5];
            String city = (String) objects[6];
            String city_code = (String) objects[7];
            Double x_coord_start = 0.0;
            Double y_coord_start = 0.0;
            Double x_coord_end = 0.0;
            Double y_coord_end = 0.0;
            List<Object[]> bdzCoord_message_start = bdz_relationship_message_repository.getBDZCoord_Message(pms_id_start);
            List<Object[]> bdzCoord_message_end = bdz_relationship_message_repository.getBDZCoord_Message(pms_id_end);
            if (0 != bdzCoord_message_start.size() && 0 != bdzCoord_message_end.size()){
                x_coord_start = (Double) bdzCoord_message_start.get(0)[0];
                y_coord_start = (Double) bdzCoord_message_start.get(0)[1];
                x_coord_end = (Double) bdzCoord_message_end.get(0)[0];
                y_coord_end = (Double) bdzCoord_message_end.get(0)[1];
            }
            BDZ_Relationship_Message bdz_relationship_message = new BDZ_Relationship_Message(pms_id_start,dydj_start,name_start,pms_id_end,dydj_end,name_end,x_coord_start,y_coord_start,x_coord_end,y_coord_end,city,city_code);
            bdz_relationship_messages.add(bdz_relationship_message);
        }
        return bdz_relationship_messages;
    }

    public List<Object[]> findCity_Message_Html(String cityName){
        List<Object[]> cityMessageList = city_message_repository.selectCityMessage(cityName);
        return cityMessageList;
    }


    /**
     * 读取json文件，获取城市信息
     */
    public List<City_Message> findCity_Message(){

        Double xDouble = 0.0;
        Double yDouble = 0.0;

        JsonUtils utils = new JsonUtils();
        String path = DwyyApplication.class.getClassLoader().getResource("static/json").getPath();
        ArrayList<String> arr = utils.getFile(new File(path));
        for (String pathFile : arr){
            System.out.println(pathFile);
            String temp[] = pathFile.split("\\\\");
            String s = temp[temp.length - 1];
            String subStringName = s.substring(0, s.lastIndexOf("."));

            String jsonDataFile = utils.readJsonFile(pathFile);
            com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(jsonDataFile);
            List<JSONObject> listFeatures = (List<JSONObject>) jsonObject.get("features");
            for (int i = 0;i<listFeatures.size();i++){
                city_message = new City_Message();
                Map<String,String> propertiesList = (Map<String,String>) listFeatures.get(i).get("properties");
                for (Map.Entry map:propertiesList.entrySet()){
                    if (map.getKey().equals("name")){
                        String value = (String) map.getValue();
                        city_message.setCITYNAME(value);
                        city_message.setCITYCODE(subStringName);
                    }
                    if (map.getKey().equals("cp")){
                        List<Object> value = (List<Object>) map.getValue();
                        xDouble = Double.parseDouble(value.get(0).toString());
                        yDouble = Double.parseDouble(value.get(1).toString());
                        city_message.setX_COORD_CITY(xDouble);
                        city_message.setY_COORD_CITY(yDouble);
                    }
                }
                cityMessageList.add(city_message);
            }

        }
        return cityMessageList;
    }

    /**
     * 由于前期没有数据，需要导入Excel作为假数据，因此读取Excel
     */
    public void readExcel_disposeData(boolean result){
        ReadExcel utils = new ReadExcel();
        String pathName_GS_BDZ = "F:\\工作文档\\复合关联-拓展监测\\20190826-变电站对应关系\\变电站关系数据_甘肃.xls";
        String pathName_BDZ_Coord = "F:\\工作文档\\复合关联-拓展监测\\20190826-变电站对应关系\\35kV及以上变电站(2).xls";
        List<GS_BDZ> gs_bdzsList = null;
        List<BDZ_Coord> bdz_coordList = null;
        try {
            if (result){
                bdz_coord_repository.deleteAll();
                gs_bdz_repository.deleteAll();

                bdz_coordList = utils.readSourceData_BDZ_Coord(pathName_BDZ_Coord);
                bdz_coord_repository.saveAll(bdz_coordList);
                gs_bdzsList = utils.readSourceData_GS_BDZ(pathName_GS_BDZ);
                gs_bdz_repository.saveAll(gs_bdzsList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
