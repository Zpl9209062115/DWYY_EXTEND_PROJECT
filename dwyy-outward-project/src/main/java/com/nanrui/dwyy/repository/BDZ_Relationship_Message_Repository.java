package com.nanrui.dwyy.repository;

import com.nanrui.dwyy.bean.BDZ_Relationship_Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BDZ_Relationship_Message_Repository extends JpaRepository<BDZ_Relationship_Message,String> {

    @Query(value = "SELECT t.SBMC,t.X_COORD,t.Y_COORD,t.SBID FROM substation_particulars_gs m,substation_particulars t WHERE m.pms_id_start = t.SBID or m.pms_id_end = t.SBID GROUP BY t.SBID")
    public List<Object[]> getBDZRestlt();

    @Query(value = "SELECT pms_id_start,dtdj_start,name_start,pms_id_end,dydj_end,name_end,city,city_code FROM substation_particulars_gs where city_code = ?1 and dydj_end like ?2")
    public List<Object[]> getBDZ_Message(String cityCode,String condition);

    @Query(value = "SELECT pms_id_start,dtdj_start,name_start,pms_id_end,dydj_end,name_end,city,city_code FROM substation_particulars_gs where dydj_end like ?1")
    public List<Object[]> getBDZ_Message_condition(String condition);

    @Query(value = "SELECT pms_id_start,dtdj_start,name_start,pms_id_end,dydj_end,name_end,city,city_code FROM substation_particulars_gs where city_code = ?1")
    public List<Object[]> getBDZ_Message_city(String cityCode);

    @Query(value = "SELECT pms_id_start,dtdj_start,name_start,pms_id_end,dydj_end,name_end,city,city_code FROM substation_particulars_gs")
    public List<Object[]> getBDZ_Message();

    @Query(value = "SELECT X_COORD,Y_COORD FROM substation_particulars WHERE sbid LIKE ?1")
    public List<Object[]> getBDZCoord_Message(String bdzID);

    @Query(value = "SELECT city,city_code,dtdj_start,dydj_end,name_end,name_start,pms_id_end,pms_id_start,x_coord_end,x_coord_start,y_coord_end,y_coord_start FROM substation_particulars_bdz_message WHERE x_coord_end <> 0 AND x_coord_end <> 0 AND y_coord_end <> 0 AND y_coord_start <> 0")
    public List<Object[]> getBDZ_MessageForHtml();

    @Query(value = "SELECT city,city_code,dtdj_start,dydj_end,name_end,name_start,pms_id_end,pms_id_start,x_coord_end,x_coord_start,y_coord_end,y_coord_start FROM substation_particulars_bdz_message WHERE x_coord_end <> 0 AND x_coord_end <> 0 AND y_coord_end <> 0 AND y_coord_start <> 0 AND dydj_end like ?1")
    public List<Object[]> getBDZ_MessageForHtml_condition(String condition);

    @Query(value = "SELECT city,city_code,dtdj_start,dydj_end,name_end,name_start,pms_id_end,pms_id_start,x_coord_end,x_coord_start,y_coord_end,y_coord_start FROM substation_particulars_bdz_message WHERE x_coord_end <> 0 AND x_coord_end <> 0 AND y_coord_end <> 0 AND y_coord_start <> 0 AND city_code LIKE ?1")
    public List<Object[]> getBDZ_MessageForHtml_city(String cityname);

    @Query(value = "SELECT city,city_code,dtdj_start,dydj_end,name_end,name_start,pms_id_end,pms_id_start,x_coord_end,x_coord_start,y_coord_end,y_coord_start FROM substation_particulars_bdz_message WHERE x_coord_end <> 0 AND x_coord_end <> 0 AND y_coord_end <> 0 AND y_coord_start <> 0 AND city_code LIKE ?1 AND dydj_end like ?2")
    public List<Object[]> getBDZ_MessageForHtml(String cityname,String condition);
}
