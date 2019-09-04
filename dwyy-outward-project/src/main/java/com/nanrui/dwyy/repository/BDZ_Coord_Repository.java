package com.nanrui.dwyy.repository;

import com.nanrui.dwyy.bean.BDZ_Coord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BDZ_Coord_Repository extends JpaRepository<BDZ_Coord,Integer> {


    @Query(value = "SELECT X_COORD,Y_COORD FROM substation_particulars WHERE SBID = ?1")
    public List<Object[]> getLocation(String sbid);
}
