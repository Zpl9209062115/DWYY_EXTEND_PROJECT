package com.nanrui.dwyy.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 变电站坐标信息
 */
@Entity(name = "substation_particulars")
@Table(name = "substation_particulars")
public class BDZ_Coord implements Serializable {
    @Id
    private Double OID;
    @Column(name = "SBMC")
    private String SBMC;
    @Column(name = "X_COORD")
    private Double X_COORD;
    @Column(name = "Y_COORD")
    private Double Y_COORD;
    @Column(name = "YXBH")
    private String YXBH;
    @Column(name = "SBZLX")
    private Double SBZLX;
    @Column(name = "SSZRQ")
    private Double SSZRQ;
    @Column(name = "STATE_ID")
    private Double STATE_ID;
    @Column(name = "FHJD")
    private Double FHJD;
    @Column(name = "CONNECTION")
    private String CONNECTION;
    @Column(name = "SBID")
    private String SBID;
    @Column(name = "DYDJ")
    private Double DYDJ;
    @Column(name = "YXDW")
    private String YXDW;
    @Column(name = "FHDX")
    private Double FHDX;
    @Column(name = "SFBZ")
    private String SFBZ;
    @Column(name = "BZDX")
    private String BZDX;
    @Column(name = "BZYS")
    private String BZYS;
    @Column(name = "BZFW")
    private String BZFW;
    @Column(name = "PLFS")
    private String PLFS;
    @Column(name = "DHZS")
    private String DHZS;
    @Column(name = "X")
    private Double X;
    @Column(name = "Y")
    private Double Y;
    @Column(name = "TYPE")
    private Double TYPE;
    @Column(name = "GRIDSIZE")
    private String GRIDSIZE;
    @Column(name = "BZXSZD")
    private String BZXSZD;
    @Column(name = "BZNR")
    private String BZNR;
    @Column(name = "SSDS")
    private String SSDS;
    @Column(name = "KZFHID")
    private String KZFHID;
    @Column(name = "APPTYPE")
    private Double APPTYPE;
    @Column(name = "RLBZ")
    private String RLBZ;
    @Column(name = "SSKX")
    private String SSKX;
    @Column(name = "SSTQLX")
    private String SSTQLX;
    @Column(name = "SSTQ")
    private String SSTQ;
    @Column(name = "YHBH")
    private String YHBH;
    @Column(name = "VERSIONID")
    private Double VERSIONID;
    @Column(name = "SSDKX")
    private String SSDKX;
    @Column(name = "SSDKXZX")
    private String SSDKXZX;
    @Column(name = "PBZRL")
    private Double PBZRL;
    @Column(name = "SFYC")
    private String SFYC;
    @Column(name = "SFDXKGZ")
    private String SFDXKGZ;

    public BDZ_Coord() {
    }

    public BDZ_Coord(Double OID, String SBMC, Double x_COORD, Double y_COORD, String YXBH, Double SBZLX, Double SSZRQ, Double STATE_ID, Double FHJD, String CONNECTION, String SBID, Double DYDJ, String YXDW, Double FHDX, String SFBZ, String BZDX, String BZYS, String BZFW, String PLFS, String DHZS, Double x, Double y, Double TYPE, String GRIDSIZE, String BZXSZD, String BZNR, String SSDS, String KZFHID, Double APPTYPE, String RLBZ, String SSKX, String SSTQLX, String SSTQ, String YHBH, Double VERSIONID, String SSDKX, String SSDKXZX, Double PBZRL, String SFYC, String SFDXKGZ) {
        this.OID = OID;
        this.SBMC = SBMC;
        X_COORD = x_COORD;
        Y_COORD = y_COORD;
        this.YXBH = YXBH;
        this.SBZLX = SBZLX;
        this.SSZRQ = SSZRQ;
        this.STATE_ID = STATE_ID;
        this.FHJD = FHJD;
        this.CONNECTION = CONNECTION;
        this.SBID = SBID;
        this.DYDJ = DYDJ;
        this.YXDW = YXDW;
        this.FHDX = FHDX;
        this.SFBZ = SFBZ;
        this.BZDX = BZDX;
        this.BZYS = BZYS;
        this.BZFW = BZFW;
        this.PLFS = PLFS;
        this.DHZS = DHZS;
        X = x;
        Y = y;
        this.TYPE = TYPE;
        this.GRIDSIZE = GRIDSIZE;
        this.BZXSZD = BZXSZD;
        this.BZNR = BZNR;
        this.SSDS = SSDS;
        this.KZFHID = KZFHID;
        this.APPTYPE = APPTYPE;
        this.RLBZ = RLBZ;
        this.SSKX = SSKX;
        this.SSTQLX = SSTQLX;
        this.SSTQ = SSTQ;
        this.YHBH = YHBH;
        this.VERSIONID = VERSIONID;
        this.SSDKX = SSDKX;
        this.SSDKXZX = SSDKXZX;
        this.PBZRL = PBZRL;
        this.SFYC = SFYC;
        this.SFDXKGZ = SFDXKGZ;
    }

    public Double getOID() {
        return OID;
    }

    public void setOID(Double OID) {
        this.OID = OID;
    }

    public String getSBMC() {
        return SBMC;
    }

    public void setSBMC(String SBMC) {
        this.SBMC = SBMC;
    }

    public Double getX_COORD() {
        return X_COORD;
    }

    public void setX_COORD(Double x_COORD) {
        X_COORD = x_COORD;
    }

    public Double getY_COORD() {
        return Y_COORD;
    }

    public void setY_COORD(Double y_COORD) {
        Y_COORD = y_COORD;
    }

    public String getYXBH() {
        return YXBH;
    }

    public void setYXBH(String YXBH) {
        this.YXBH = YXBH;
    }

    public Double getSBZLX() {
        return SBZLX;
    }

    public void setSBZLX(Double SBZLX) {
        this.SBZLX = SBZLX;
    }

    public Double getSSZRQ() {
        return SSZRQ;
    }

    public void setSSZRQ(Double SSZRQ) {
        this.SSZRQ = SSZRQ;
    }

    public Double getSTATE_ID() {
        return STATE_ID;
    }

    public void setSTATE_ID(Double STATE_ID) {
        this.STATE_ID = STATE_ID;
    }

    public Double getFHJD() {
        return FHJD;
    }

    public void setFHJD(Double FHJD) {
        this.FHJD = FHJD;
    }

    public String getCONNECTION() {
        return CONNECTION;
    }

    public void setCONNECTION(String CONNECTION) {
        this.CONNECTION = CONNECTION;
    }

    public String getSBID() {
        return SBID;
    }

    public void setSBID(String SBID) {
        this.SBID = SBID;
    }

    public Double getDYDJ() {
        return DYDJ;
    }

    public void setDYDJ(Double DYDJ) {
        this.DYDJ = DYDJ;
    }

    public String getYXDW() {
        return YXDW;
    }

    public void setYXDW(String YXDW) {
        this.YXDW = YXDW;
    }

    public Double getFHDX() {
        return FHDX;
    }

    public void setFHDX(Double FHDX) {
        this.FHDX = FHDX;
    }

    public String getSFBZ() {
        return SFBZ;
    }

    public void setSFBZ(String SFBZ) {
        this.SFBZ = SFBZ;
    }

    public String getBZDX() {
        return BZDX;
    }

    public void setBZDX(String BZDX) {
        this.BZDX = BZDX;
    }

    public String getBZYS() {
        return BZYS;
    }

    public void setBZYS(String BZYS) {
        this.BZYS = BZYS;
    }

    public String getBZFW() {
        return BZFW;
    }

    public void setBZFW(String BZFW) {
        this.BZFW = BZFW;
    }

    public String getPLFS() {
        return PLFS;
    }

    public void setPLFS(String PLFS) {
        this.PLFS = PLFS;
    }

    public String getDHZS() {
        return DHZS;
    }

    public void setDHZS(String DHZS) {
        this.DHZS = DHZS;
    }

    public Double getX() {
        return X;
    }

    public void setX(Double x) {
        X = x;
    }

    public Double getY() {
        return Y;
    }

    public void setY(Double y) {
        Y = y;
    }

    public Double getTYPE() {
        return TYPE;
    }

    public void setTYPE(Double TYPE) {
        this.TYPE = TYPE;
    }

    public String getGRIDSIZE() {
        return GRIDSIZE;
    }

    public void setGRIDSIZE(String GRIDSIZE) {
        this.GRIDSIZE = GRIDSIZE;
    }

    public String getBZXSZD() {
        return BZXSZD;
    }

    public void setBZXSZD(String BZXSZD) {
        this.BZXSZD = BZXSZD;
    }

    public String getBZNR() {
        return BZNR;
    }

    public void setBZNR(String BZNR) {
        this.BZNR = BZNR;
    }

    public String getSSDS() {
        return SSDS;
    }

    public void setSSDS(String SSDS) {
        this.SSDS = SSDS;
    }

    public String getKZFHID() {
        return KZFHID;
    }

    public void setKZFHID(String KZFHID) {
        this.KZFHID = KZFHID;
    }

    public Double getAPPTYPE() {
        return APPTYPE;
    }

    public void setAPPTYPE(Double APPTYPE) {
        this.APPTYPE = APPTYPE;
    }

    public String getRLBZ() {
        return RLBZ;
    }

    public void setRLBZ(String RLBZ) {
        this.RLBZ = RLBZ;
    }

    public String getSSKX() {
        return SSKX;
    }

    public void setSSKX(String SSKX) {
        this.SSKX = SSKX;
    }

    public String getSSTQLX() {
        return SSTQLX;
    }

    public void setSSTQLX(String SSTQLX) {
        this.SSTQLX = SSTQLX;
    }

    public String getSSTQ() {
        return SSTQ;
    }

    public void setSSTQ(String SSTQ) {
        this.SSTQ = SSTQ;
    }

    public String getYHBH() {
        return YHBH;
    }

    public void setYHBH(String YHBH) {
        this.YHBH = YHBH;
    }

    public Double getVERSIONID() {
        return VERSIONID;
    }

    public void setVERSIONID(Double VERSIONID) {
        this.VERSIONID = VERSIONID;
    }

    public String getSSDKX() {
        return SSDKX;
    }

    public void setSSDKX(String SSDKX) {
        this.SSDKX = SSDKX;
    }

    public String getSSDKXZX() {
        return SSDKXZX;
    }

    public void setSSDKXZX(String SSDKXZX) {
        this.SSDKXZX = SSDKXZX;
    }

    public Double getPBZRL() {
        return PBZRL;
    }

    public void setPBZRL(Double PBZRL) {
        this.PBZRL = PBZRL;
    }

    public String getSFYC() {
        return SFYC;
    }

    public void setSFYC(String SFYC) {
        this.SFYC = SFYC;
    }

    public String getSFDXKGZ() {
        return SFDXKGZ;
    }

    public void setSFDXKGZ(String SFDXKGZ) {
        this.SFDXKGZ = SFDXKGZ;
    }
}
