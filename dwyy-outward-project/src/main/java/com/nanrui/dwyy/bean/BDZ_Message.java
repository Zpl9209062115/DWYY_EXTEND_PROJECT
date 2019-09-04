package com.nanrui.dwyy.bean;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "bdz_message")
@Table(name = "bdz_message")
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class BDZ_Message implements Serializable {
    @Id
    @GeneratedValue(generator = "jpa-uuid")//自增主键
    private String id;
    @Column(name = "BDZ_NAME")
    private String BDZ_NAME;
    @Column(name = "X_COORD_BDZ")
    private Double X_COORD_BDZ;
    @Column(name = "Y_COORD_BDZ")
    private Double Y_COORD_BDZ;
    @Column(name = "CITYCODE")
    private String CITYCODE;

    public BDZ_Message(String BDZ_NAME, Double x_COORD_BDZ, Double y_COORD_BDZ, String CITYCODE) {
        this.BDZ_NAME = BDZ_NAME;
        X_COORD_BDZ = x_COORD_BDZ;
        Y_COORD_BDZ = y_COORD_BDZ;
        this.CITYCODE = CITYCODE;
    }

    public BDZ_Message() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBDZ_NAME() {
        return BDZ_NAME;
    }

    public void setBDZ_NAME(String BDZ_NAME) {
        this.BDZ_NAME = BDZ_NAME;
    }

    public Double getX_COORD_BDZ() {
        return X_COORD_BDZ;
    }

    public void setX_COORD_BDZ(Double x_COORD_BDZ) {
        X_COORD_BDZ = x_COORD_BDZ;
    }

    public Double getY_COORD_BDZ() {
        return Y_COORD_BDZ;
    }

    public void setY_COORD_BDZ(Double y_COORD_BDZ) {
        Y_COORD_BDZ = y_COORD_BDZ;
    }

    public String getCITYCODE() {
        return CITYCODE;
    }

    public void setCITYCODE(String CITYCODE) {
        this.CITYCODE = CITYCODE;
    }
}
