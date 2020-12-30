package com.offcn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
* 消息生产者
 */
@RestController
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/send")
    public void send(String text){
        jmsMessagingTemplate.convertAndSend("offcn",text);
        System.out.println("发送暗号offcn消息" + text);
    }

    /*
    发送集合map数据
    */
    @RequestMapping("/send_map")
    public void sendMap(){
        Map map = new HashMap();
        map.put("mobile","15822429071");
        map.put("content","恭喜中了10000000000");
        jmsMessagingTemplate.convertAndSend("offcn_map",map);
        System.out.println("发送暗号offcn_map 消息   " + map);
    }

    @RequestMapping("/sendSms")
    public void sendSms(){
        Map map = new HashMap();
        map.put("sign_name","浪书城");
        map.put("mobile","15935754793");
        map.put("template_code","SMS_205878937");
        map.put("key","{\"code\":\"iamyourfather\"}");

        jmsMessagingTemplate.convertAndSend("sendsns",map);
    }
}
