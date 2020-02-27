package com.winterchen.demo.model;

public class BoxDeviceDomain {

//    {"dev_name":"测试设备1","data":[{"unit":"无","reg":"采集点3","value":"0"}],"ccid":"89860430111890796238","cmd":"reg_report","dev_type":"YS-DGN-19A","wireless_type":"NBIoT-MQTT","dev_id":"37383637064737301D003400"}

    private int boxId;
    private String devName;
    private String ccid;
    private String cmd;
    private String devType;
    private String wirelessType;
    private String devId;

    public BoxDeviceDomain() {
    }

    public BoxDeviceDomain(String devName, String ccid, String cmd, String devType, String wirelessType, String devId) {
        this.devName = devName;
        this.ccid = ccid;
        this.cmd = cmd;
        this.devType = devType;
        this.wirelessType = wirelessType;
        this.devId = devId;
    }

    public int getBoxId() {
        return boxId;
    }

    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }

    public String getDevName() {
        return devName;
    }

    public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getCcid() {
        return ccid;
    }

    public void setCcid(String ccid) {
        this.ccid = ccid;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getDevType() {
        return devType;
    }

    public void setDevType(String devType) {
        this.devType = devType;
    }

    public String getWirelessType() {
        return wirelessType;
    }

    public void setWirelessType(String wirelessType) {
        this.wirelessType = wirelessType;
    }

    public String getDevId() {
        return devId;
    }

    public void setDevId(String devId) {
        this.devId = devId;
    }
}
