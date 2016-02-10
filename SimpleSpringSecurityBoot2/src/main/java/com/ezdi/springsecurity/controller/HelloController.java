package com.ezdi.springsecurity.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by EZDI\manjunath.y on 9/2/16.
 */
@RestController
@ComponentScan(basePackages="com.ezdi.springsecurity")
@RequestMapping(path = "/")
public class HelloController {

    @RequestMapping(path = "/")
    public String hello(){
        return "hello yoyoi";
    }
}
