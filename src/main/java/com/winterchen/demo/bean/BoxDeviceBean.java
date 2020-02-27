package com.winterchen.demo.bean;

import java.util.List;

public class BoxDeviceBean {
    /**
     * dev_name : 测试设备1
     * data : [{"unit":"无","reg":"采集点3","value":"0"}]
     * ccid : 89860430111890796238
     * cmd : reg_report
     * dev_type : YS-DGN-19A
     * wireless_type : NBIoT-MQTT
     * dev_id : 37383637064737301D003400
     */

    private String dev_name;
    private String ccid;
    private String cmd;
    private String dev_type;
    private String wireless_type;
    private String dev_id;
    private List<DataBean> data;

    public String getDev_name() {
        return dev_name;
    }

    public void setDev_name(String dev_name) {
        this.dev_name = dev_name;
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

    public String getDev_type() {
        return dev_type;
    }

    public void setDev_type(String dev_type) {
        this.dev_type = dev_type;
    }

    public String getWireless_type() {
        return wireless_type;
    }

    public void setWireless_type(String wireless_type) {
        this.wireless_type = wireless_type;
    }

    public String getDev_id() {
        return dev_id;
    }

    public void setDev_id(String dev_id) {
        this.dev_id = dev_id;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * unit : 无
         * reg : 采集点3
         * value : 0
         */

        private String unit;
        private String reg;
        private String value;

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

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
