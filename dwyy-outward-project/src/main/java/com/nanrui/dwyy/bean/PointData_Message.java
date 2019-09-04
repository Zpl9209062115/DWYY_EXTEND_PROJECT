package com.nanrui.dwyy.bean;

import java.io.Serializable;

public class PointData_Message implements Serializable {

    private String pms_id;

    private String name;

    private Double x_coord;

    private Double y_coord;

    private String dydj;

    public PointData_Message(String pms_id, String name, Double x_coord, Double y_coord, String dydj) {
        this.pms_id = pms_id;
        this.name = name;
        this.x_coord = x_coord;
        this.y_coord = y_coord;
        this.dydj = dydj;
    }

    public PointData_Message() {
    }

    public String getPms_id() {
        return pms_id;
    }

    public void setPms_id(String pms_id) {
        this.pms_id = pms_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getX_coord() {
        return x_coord;
    }

    public void setX_coord(Double x_coord) {
        this.x_coord = x_coord;
    }

    public Double getY_coord() {
        return y_coord;
    }

    public void setY_coord(Double y_coord) {
        this.y_coord = y_coord;
    }

    public String getDydj() {
        return dydj;
    }

    public void setDydj(String dydj) {
        this.dydj = dydj;
    }
}
