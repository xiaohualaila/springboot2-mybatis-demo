package com.winterchen.demo.config;

import com.alibaba.fastjson.JSON;
import com.aliyun.openservices.ons.api.*;
import com.winterchen.demo.bean.BoxDeviceBean;
import com.winterchen.demo.model.BoxDeviceDomain;
import com.winterchen.demo.model.BoxUnit;
import com.winterchen.demo.service.user.BoxDeviceService;
import com.winterchen.demo.service.user.BoxUnitService;
import com.winterchen.demo.service.user.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Properties;

/**
 * RocketMQ配置
 */
@Configuration
public class RocketMQConfig {
    @Autowired
    private DeviceService deviceService;

    @Autowired
    private BoxDeviceService boxDeviceService;

    @Autowired
    private BoxUnitService boxUnitService;
    /**
     * 生产者配置
     * @return
     */
    @Bean
    public Producer producer () {
        Properties properties = new Properties();
        properties.setProperty(PropertyKeyConst.GROUP_ID, "GID_hello");
        // 鉴权用 AccessKey，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.AccessKey,"LTAIVF4gw9JeVOXh");
        // 鉴权用 SecretKey，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, "rSiAZKbFgljE4QPaKyU8KfDyAEgPiB");
        // 设置 TCP 接入域名，进入控制台的实例管理页面，在页面上方选择实例后，在实例信息中的“获取接入点信息”区域查看
        properties.put(PropertyKeyConst.NAMESRV_ADDR,
                "http://MQ_INST_1355909077447958_BcD9mhqI.mq-internet-access.mq-internet.aliyuncs.com:80");
        //通过 PropertyKeyConst.EXACTLYONCE_DELIVERY 开启 exactly-once 投递语义(保证拥有多个消费者时消息只被消费一次)
        properties.put(PropertyKeyConst.EXACTLYONCE_DELIVERY, "true");
        Producer producer = ONSFactory.createProducer(properties);
        // 在发送消息前，必须调用 start 方法来启动 Producer，只需调用一次即可
        producer.start();

        return producer;
    }

    /**
     * 消费者1配置
     * @return
     */
//    @Bean
//    public Consumer consumer1 () {
//        Properties properties = new Properties();
//        // 您在控制台创建的 Group ID
//        properties.put(PropertyKeyConst.GROUP_ID, "GID_hello");
//        // 鉴权用 AccessKey，在阿里云服务器管理控制台创建
//        properties.put(PropertyKeyConst.AccessKey,"LTAIVF4gw9JeVOXh");
//        // 鉴权用 SecretKey，在阿里云服务器管理控制台创建
//        properties.put(PropertyKeyConst.SecretKey, "rSiAZKbFgljE4QPaKyU8KfDyAEgPiB");
//        // 设置 TCP 接入域名，进入控制台的实例管理页面，在页面上方选择实例后，在实例信息中的“获取接入点信息”区域查看
//        properties.put(PropertyKeyConst.NAMESRV_ADDR,
//                "http://MQ_INST_1355909077447958_BcD9mhqI.mq-internet-access.mq-internet.aliyuncs.com:80");
//        Consumer consumer = ONSFactory.createConsumer(properties);
//        //创建消息监听和消息处理逻辑
//        consumer.subscribe("topic1", "*", new MessageListener() {
//            @Override
//            public Action consume(Message message, ConsumeContext context) {
//               // System.out.println("RocketMQConfig Receive1: " +  new String (message.getBody()) + " " + message.getMsgID());
//                String msg = new String (message.getBody());
//                DeviceBean bean = JSON.parseObject(msg, DeviceBean.class);
//                DeviceDomain deviceDomain = new DeviceDomain(
//                        bean.getDeviceType(),bean.getIotId(),bean.getRequestId(),
//                        bean.getProductKey(), bean.getDeviceName(),
//                        bean.getItems().getTemperature().getValue(),
//                        bean.getItems().getHumidity().getValue());
//               LogUtil.print("+++++++++++++++++++++++");
//                deviceService.addDevice(deviceDomain);
//                return Action.CommitMessage;
//            }
//        });
//        //启动监听
//        consumer.start();
//
//        return consumer;
//    }

    /**
     * 消费者2配置
     * @return
     */
    @Bean
    public Consumer consumer2 () {
        Properties properties = new Properties();
        // 您在控制台创建的 Group ID
        properties.put(PropertyKeyConst.GROUP_ID, "GID_hello");
        // 鉴权用 AccessKey，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.AccessKey,"LTAIVF4gw9JeVOXh");
        // 鉴权用 SecretKey，在阿里云服务器管理控制台创建
        properties.put(PropertyKeyConst.SecretKey, "rSiAZKbFgljE4QPaKyU8KfDyAEgPiB");
        // 设置 TCP 接入域名，进入控制台的实例管理页面，在页面上方选择实例后，在实例信息中的“获取接入点信息”区域查看
        properties.put(PropertyKeyConst.NAMESRV_ADDR,
                "http://MQ_INST_1355909077447958_BcD9mhqI.mq-internet-access.mq-internet.aliyuncs.com:80");
        Consumer consumer = ONSFactory.createConsumer(properties);
        //创建消息监听和消息处理逻辑
        consumer.subscribe("topic1", "*", new MessageListener() {
            @Override
            public Action consume(Message message, ConsumeContext context) {
                System.out.println("Receive2: " + new String (message.getBody()) + " " + message.getMsgID());
                String msg = new String (message.getBody());
                BoxDeviceBean bean = JSON.parseObject(msg, BoxDeviceBean.class);
                BoxDeviceDomain boxDeviceDomain = new BoxDeviceDomain(
                        bean.getDev_name(),
                        bean.getCcid(),
                        bean.getCmd(),
                        bean.getDev_type(),
                        bean.getWireless_type(),
                        bean.getDev_id()
                );

                // boxDeviceService.addDevice(boxDeviceDomain);
                BoxDeviceDomain device = boxDeviceService.selectBoxDevice(boxDeviceDomain.getDevId());
                if(device!=null){
                    boxDeviceService.updateBoxDevice(boxDeviceDomain);
                }else {
                    boxDeviceService.addDevice(device);
                }

                List<BoxDeviceBean.DataBean> dataBeans = bean.getData();
                for (BoxDeviceBean.DataBean dataBean:dataBeans) {
                    BoxUnit boxUnit = new BoxUnit(
                            bean.getCcid(),
                            dataBean.getUnit(),
                            dataBean.getReg(),
                            dataBean.getValue()
                    );
                   // boxUnitService.addDevice(boxUnit);
                    BoxUnit unit = boxUnitService.selectBoxDevice( bean.getCcid());
                    if(unit!=null){
                        boxUnitService.updateBoxUnit(boxUnit);
                    }else{
                         boxUnitService.addDevice(boxUnit);
                    }
                }
                return Action.CommitMessage;
            }
        });
        //启动监听
        consumer.start();

        return consumer;
    }
}
