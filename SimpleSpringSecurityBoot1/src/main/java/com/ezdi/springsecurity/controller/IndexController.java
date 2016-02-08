package com.ezdi.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by EZDI\manjunath.y on 8/2/16.
 */
@RestController
@RequestMapping(path = "/")
public class IndexController {


    @RequestMapping(path="/", method= RequestMethod.GET)
    @ResponseBody
    public String hello(){
        return "yoyoi";
    }
}
