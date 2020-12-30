package com.offcn.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Consumer {

    //接收暗号
    @JmsListener(destination = "offcn")
    public void readMessage(String text){
        System.out.println("接收到消息" + text);
    }

    //接收集合数据
    @JmsListener(destination = "offcn_map")
    public void readMap(Map map){
        System.out.println("接收到map数据" + map);
    }
}
