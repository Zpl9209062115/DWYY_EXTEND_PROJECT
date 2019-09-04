package com.nanrui.dwyy.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "substation_particulars_bdz_message")
@Table(name = "substation_particulars_bdz_message")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class BDZ_Relationship_Message implements Serializable {

    @Id
    @GeneratedValue(generator = "jpa-uuid")//自增主键
    private String id;
    @Column(name = "pms_id_start")
    private String pms_id_start;
    @Column(name = "dtdj_start")
    private String dtdj_start;
    @Column(name = "name_start")
    private String name_start;
    @Column(name = "pms_id_end")
    private String pms_id_end;
    @Column(name = "dydj_end")
    private String dydj_end;
    @Column(name = "name_end")
    private String name_end;
    @Column(name = "x_coord_start")
    private Double x_coord_start;
    @Column(name = "y_coord_start")
    private Double y_coord_start;
    @Column(name = "x_coord_end")
    private Double x_coord_end;
    @Column(name = "y_coord_end")
    private Double y_coord_end;
    @Column(name = "city")
    private String city;
    @Column(name = "city_code")
    private String city_code;

    public BDZ_Relationship_Message(String pms_id_start, String dtdj_start, String name_start, String pms_id_end, String dydj_end, String name_end, Double x_coord_start, Double y_coord_start, Double x_coord_end, Double y_coord_end, String city, String city_code) {
        this.pms_id_start = pms_id_start;
        this.dtdj_start = dtdj_start;
        this.name_start = name_start;
        this.pms_id_end = pms_id_end;
        this.dydj_end = dydj_end;
        this.name_end = name_end;
        this.x_coord_start = x_coord_start;
        this.y_coord_start = y_coord_start;
        this.x_coord_end = x_coord_end;
        this.y_coord_end = y_coord_end;
        this.city = city;
        this.city_code = city_code;
    }

    public BDZ_Relationship_Message() {
    }

    public String getPms_id_start() {
        return pms_id_start;
    }

    public void setPms_id_start(String pms_id_start) {
        this.pms_id_start = pms_id_start;
    }

    public String getDtdj_start() {
        return dtdj_start;
    }

    public void setDtdj_start(String dtdj_start) {
        this.dtdj_start = dtdj_start;
    }

    public String getName_start() {
        return name_start;
    }

    public void setName_start(String name_start) {
        this.name_start = name_start;
    }

    public String getPms_id_end() {
        return pms_id_end;
    }

    public void setPms_id_end(String pms_id_end) {
        this.pms_id_end = pms_id_end;
    }

    public String getDydj_end() {
        return dydj_end;
    }

    public void setDydj_end(String dydj_end) {
        this.dydj_end = dydj_end;
    }

    public String getName_end() {
        return name_end;
    }

    public void setName_end(String name_end) {
        this.name_end = name_end;
    }

    public Double getX_coord_start() {
        return x_coord_start;
    }

    public void setX_coord_start(Double x_coord_start) {
        this.x_coord_start = x_coord_start;
    }

    public Double getY_coord_start() {
        return y_coord_start;
    }

    public void setY_coord_start(Double y_coord_start) {
        this.y_coord_start = y_coord_start;
    }

    public Double getX_coord_end() {
        return x_coord_end;
    }

    public void setX_coord_end(Double x_coord_end) {
        this.x_coord_end = x_coord_end;
    }

    public Double getY_coord_end() {
        return y_coord_end;
    }

    public void setY_coord_end(Double y_coord_end) {
        this.y_coord_end = y_coord_end;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity_code() {
        return city_code;
    }

    public void setCity_code(String city_code) {
        this.city_code = city_code;
    }
}
