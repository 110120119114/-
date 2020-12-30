package com.offcn.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private Environment env;//读取配置文件

    @RequestMapping("/info")
    public String info(){
        return "hello world" + env.getProperty("url");
    }
}


