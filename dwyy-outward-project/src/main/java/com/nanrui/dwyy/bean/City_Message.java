package com.nanrui.dwyy.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "city_message")
@Table(name = "city_message")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class City_Message implements Serializable {
    @Id
    @GeneratedValue(generator = "jpa-uuid")//自增主键
    private String id;
    @Column(name = "CITYNAME")
    private String CITYNAME;
    @Column(name = "X_COORD_CITY")
    private Double X_COORD_CITY;
    @Column(name = "Y_COORD_CITY")
    private Double Y_COORD_CITY;
    @Column(name = "CITYCODE")
    private String CITYCODE;

    public City_Message(String CITYNAME, Double x_COORD_CITY, Double y_COORD_CITY, String CITYCODE) {
        this.CITYNAME = CITYNAME;
        X_COORD_CITY = x_COORD_CITY;
        Y_COORD_CITY = y_COORD_CITY;
        this.CITYCODE = CITYCODE;
    }

    public City_Message() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCITYNAME() {
        return CITYNAME;
    }

    public void setCITYNAME(String CITYNAME) {
        this.CITYNAME = CITYNAME;
    }

    public Double getX_COORD_CITY() {
        return X_COORD_CITY;
    }

    public void setX_COORD_CITY(Double x_COORD_CITY) {
        X_COORD_CITY = x_COORD_CITY;
    }

    public Double getY_COORD_CITY() {
        return Y_COORD_CITY;
    }

    public void setY_COORD_CITY(Double y_COORD_CITY) {
        Y_COORD_CITY = y_COORD_CITY;
    }

    public String getCITYCODE() {
        return CITYCODE;
    }

    public void setCITYCODE(String CITYCODE) {
        this.CITYCODE = CITYCODE;
    }
}
