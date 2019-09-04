package com.nanrui.dwyy.repository;

import com.nanrui.dwyy.bean.BDZ_Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BDZ_Message_Repository extends JpaRepository<BDZ_Message,String> {

    @Query(value = "SELECT a.name_start,a.city_code,b.X_COORD,b.Y_COORD FROM substation_particulars_gs a,substation_particulars b WHERE a.pms_id_start = b.SBID")
    public List<Object[]> selectBDZ_Message_startId();

    @Query(value = "SELECT a.name_end,a.city_code,b.X_COORD,b.Y_COORD FROM substation_particulars_gs a,substation_particulars b WHERE a.pms_id_end = b.SBID")
    public List<Object[]> selectBDZ_Message_endId();

}
