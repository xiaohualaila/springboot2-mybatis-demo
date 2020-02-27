package com.winterchen.demo.model;

public class DeviceDomain {

    /**
     * deviceType : CustomCategory
     * iotId : MSZbXxSYsABXBeZGN2ao000100
     * requestId : 123
     * productKey : a1faaaAXxqf
     * gmtCreate : 1582695851481
     * deviceName : unit1
     * items : {"Temperature":{"time":1582695851505,"value":10},"Humidity":{"time":1582695851505,"value":10}}
     */
    private Integer deviceId;
    private String deviceType;
    private String iotId;
    private String requestId;
    private String productKey;
  //  private long gmtCreate;
    private String deviceName;
    private int temperature;
    private int humidity;

    public DeviceDomain() {
    }

    public DeviceDomain(String deviceType, String iotId, String requestId, String productKey, String deviceName, int temperature, int humidity) {
        this.deviceType = deviceType;
        this.iotId = iotId;
        this.requestId = requestId;
        this.productKey = productKey;
     //   this.gmtCreate = gmtCreate;
        this.deviceName = deviceName;
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getIotId() {
        return iotId;
    }

    public void setIotId(String iotId) {
        this.iotId = iotId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

//    public long getGmtCreate() {
//        return gmtCreate;
//    }
//
//    public void setGmtCreate(long gmtCreate) {
//        this.gmtCreate = gmtCreate;
//    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
