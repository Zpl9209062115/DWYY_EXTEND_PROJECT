package com.nanrui.dwyy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.nanrui.dwyy.utils.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DwyyApplicationTests {

    @Test
    public void contextLoads() {

        String str1 = "AC07501";
        String str2 = "AC00351";
        String str3 = "AC01101";
        String str4 = "AC02201";
        String dydj = "";
        List<String> listStr = new ArrayList<>();
        listStr.add(str1);
        listStr.add(str2);
        listStr.add(str3);
        listStr.add(str4);
        for (int i = 0; i < listStr.size(); i++) {
            String s = listStr.get(i);
            if (s.substring(3,4).equals("0")){
                dydj = s.substring(4,6);
            }else{
                dydj = s.substring(3,6);
            }
            System.out.println("未截取的电压等级是:" + s);
            System.out.println("截取后的电压等级是:" + dydj);
        }

        /*JsonUtils jsonUtils = new JsonUtils();
        String path = DwyyApplication.class.getClassLoader().getResource("static/china.json").getPath();
        String s = jsonUtils.readJsonFile(path);
        com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(s);
        List<JSONObject> listFeatures = (List<JSONObject>) jsonObject.get("features");
        for (int i = 0;i<listFeatures.size();i++){
            Map<String,String> propertiesList = (Map<String,String>) listFeatures.get(i).get("properties");
            for (Map.Entry map:propertiesList.entrySet()){
                System.out.println(map.getKey() + " "+ map.getValue());
            }
        }
        System.out.println(listFeatures.toString());*/

        /*JsonUtils utils = new JsonUtils();
        String path = DwyyApplication.class.getClassLoader().getResource("static/json").getPath();
        ArrayList<String> arr = utils.getFile(new File(path));
        for (String pathFile : arr){
            System.out.println(pathFile);
            String jsonDataFile = utils.readJsonFile(pathFile);
            com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(jsonDataFile);
            List<JSONObject> listFeatures = (List<JSONObject>) jsonObject.get("features");
            for (int i = 0;i<listFeatures.size();i++){
                Map<String,String> propertiesList = (Map<String,String>) listFeatures.get(i).get("properties");
                for (Map.Entry map:propertiesList.entrySet()){
                    System.out.println(map.getKey() + " "+ map.getValue());
                }
            }
            System.out.println(listFeatures.toString());
        }
        System.out.println("文件总数"+arr.size());*/
    }

}
