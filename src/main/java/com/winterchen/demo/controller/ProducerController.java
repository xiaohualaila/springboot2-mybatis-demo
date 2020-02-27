package com.winterchen.demo.controller;


import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.SendResult;
import com.github.pagehelper.PageInfo;
import com.winterchen.demo.config.RocketMQConfig;
import com.winterchen.demo.model.DeviceDomain;
import com.winterchen.demo.service.user.DeviceService;
import com.winterchen.demo.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping(value = "/device")
public class ProducerController {
    @Resource
    private RocketMQConfig rocketMQConfig;

    @Autowired
    private DeviceService deviceService;

    /**
     * 向RocketMQ发送消息
     * @return
     */
    @GetMapping(value = "/send")
    public String send(){
        //循环发送消息100次
        for (int i =0;i<10;i++){
            //创建消息
            Message msg = new Message(
                    // 在控制台创建的 Topic，即该消息所属的 Topic 名称
                    "topic1",
                    // Message Tag。可理解为 Gmail 中的标签，对消息进行再归类，方便 Consumer 指定过滤条件在消息队列 RocketMQ 服务器过滤
                    "",
                    // Message Body。任何二进制形式的数据，消息队列 RocketMQ 不做任何干预。需要 Producer 与 Consumer 协商好一致的序列化和反序列化方式
                    ("KKKKKKKKKKKKKKKKKKKKK"+ new Date()).getBytes());

            // 设置代表消息的业务关键属性，请尽可能全局唯一，以方便您在无法正常收到消息情况下，可通过控制台查询消息并补发。注意：不设置也不会影响消息正常收发
            msg.setKey("ORDERID_" + i);
            // 发送消息，只要不抛异常就是成功
            SendResult sendResult = rocketMQConfig.producer().send(msg);
            //打印 Message ID，以便用于消息发送状态查询
            System.out.println("Send Message success. Message ID is: " + sendResult.getMessageId());
        }
        return "redirect:/";
    }
    /**
     * 接收RocketMq平台发送的消息
     * @return
     */
    @GetMapping(value = "/receiver")
    public String receiver(){
        //循环发送消息100次
        rocketMQConfig.consumer2();
        return "接收RocketMq平台发送的消息";
    }


    @GetMapping("/all")
    public Object findAllUser(
            @RequestParam(name = "pageNum", required = false, defaultValue = "1")
                    int pageNum,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10")
                    int pageSize){
        return deviceService.findAllDevices(pageNum,pageSize);
    }
}