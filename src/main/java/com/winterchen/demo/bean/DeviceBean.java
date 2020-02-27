package com.winterchen.demo.bean;

public class DeviceBean {
    /**
     * deviceType : CustomCategory
     * iotId : MSZbXxSYsABXBeZGN2ao000100
     * requestId : 123
     * productKey : a1faaaAXxqf
     * gmtCreate : 1582695851481
     * deviceName : unit1
     * items : {"Temperature":{"time":1582695851505,"value":10},"Humidity":{"time":1582695851505,"value":10}}
     */

    private String deviceType;
    private String iotId;
    private String requestId;
    private String productKey;
    private long gmtCreate;
    private String deviceName;
    private ItemsBean items;

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

    public long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public ItemsBean getItems() {
        return items;
    }

    public void setItems(ItemsBean items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * Temperature : {"time":1582695851505,"value":10}
         * Humidity : {"time":1582695851505,"value":10}
         */

        private TemperatureBean Temperature;
        private HumidityBean Humidity;

        public TemperatureBean getTemperature() {
            return Temperature;
        }

        public void setTemperature(TemperatureBean Temperature) {
            this.Temperature = Temperature;
        }

        public HumidityBean getHumidity() {
            return Humidity;
        }

        public void setHumidity(HumidityBean Humidity) {
            this.Humidity = Humidity;
        }

        public static class TemperatureBean {
            /**
             * time : 1582695851505
             * value : 10
             */

            private long time;
            private int value;

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }

        public static class HumidityBean {
            /**
             * time : 1582695851505
             * value : 10
             */

            private long time;
            private int value;

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }
        }
    }
}
