package com.netease.study.springboot.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainClass {

    @RequestMapping("/hello")
    public String sayHello(){
        return "hello,springboot!";
    }
}
