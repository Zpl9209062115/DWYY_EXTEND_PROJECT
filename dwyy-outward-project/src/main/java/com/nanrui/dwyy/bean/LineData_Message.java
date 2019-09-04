package com.nanrui.dwyy.bean;

import java.io.Serializable;

/**
 * 页面数据查询并存入对应的表及实体类
 * 1、查询变电站信息
 * testLinedata
 * var testLinedata = [{
 * 		        "fromName": "齐齐哈尔",
 * 		        "toName": "赤峰",
 * 		        "state": 0
 *                        }]
 * 查询变电站信息，其中包括:
 *          起始变电站信息 终止变电站信息
 */
public class LineData_Message implements Serializable {

    private String pms_id_start;

    private String pms_id_end;

    private String dtdj_start;

    private String dydj_end;

    private String fromName;

    private String toName;

    private Integer state;

    public LineData_Message(String pms_id_start, String pms_id_end, String dtdj_start, String dydj_end, String fromName, String toName, Integer state) {
        this.pms_id_start = pms_id_start;
        this.pms_id_end = pms_id_end;
        this.dtdj_start = dtdj_start;
        this.dydj_end = dydj_end;
        this.fromName = fromName;
        this.toName = toName;
        this.state = state;
    }

    public LineData_Message() {
    }

    public String getPms_id_start() {
        return pms_id_start;
    }

    public void setPms_id_start(String pms_id_start) {
        this.pms_id_start = pms_id_start;
    }

    public String getPms_id_end() {
        return pms_id_end;
    }

    public void setPms_id_end(String pms_id_end) {
        this.pms_id_end = pms_id_end;
    }

    public String getDtdj_start() {
        return dtdj_start;
    }

    public void setDtdj_start(String dtdj_start) {
        this.dtdj_start = dtdj_start;
    }

    public String getDydj_end() {
        return dydj_end;
    }

    public void setDydj_end(String dydj_end) {
        this.dydj_end = dydj_end;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
