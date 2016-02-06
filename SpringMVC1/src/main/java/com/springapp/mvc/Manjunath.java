package com.springapp.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by EZDI\manjunath.y on 28/1/16.
 */
@Controller
@RequestMapping("/manjunath")
public class Manjunath {

    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody
    public String hit(){
        return "ResponseBody hit";
    }
}
