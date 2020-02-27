package com.winterchen.demo.model;

public class BoxUnit {
    /**
     * unit : 无
     * reg : 采集点3
     * value : 0
     */

    private int boxUnitId;
    private String ccid;
    private String unit;
    private String reg;
    private String value;

    public BoxUnit() {
    }

    public BoxUnit(String ccid, String unit, String reg, String value) {
        this.ccid = ccid;
        this.unit = unit;
        this.reg = reg;
        this.value = value;
    }

    public int getBoxUnitId() {
        return boxUnitId;
    }

    public void setBoxUnitId(int boxUnitId) {
        this.boxUnitId = boxUnitId;
    }

    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public String getUvalue() {
        return value;
    }

    public void setUvalue(String value) {
        this.value = value;
    }
}
