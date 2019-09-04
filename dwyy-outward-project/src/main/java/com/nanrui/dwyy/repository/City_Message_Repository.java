package com.nanrui.dwyy.repository;

import com.nanrui.dwyy.bean.City_Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface City_Message_Repository extends JpaRepository<City_Message,String> {

    @Query(value = "SELECT CITYNAME,X_COORD_CITY,Y_COORD_CITY FROM city_message WHERE CITYCODE LIKE ?1")
    public List<Object[]> selectCityMessage(String cityName);

}
