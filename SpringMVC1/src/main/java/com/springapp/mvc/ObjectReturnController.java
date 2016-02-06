package com.springapp.mvc;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.springapp.misc.RandomObject;
import com.springapp.util.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by EZDI\manjunath.y on 28/1/16.
 */
@Controller
@RequestMapping("/randomObject")
public class ObjectReturnController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String ret() throws JsonProcessingException{
        RandomObject r = new RandomObject();
        ArrayList<String> list = new ArrayList<String>();
        list.add("rahul");
        list.add("priyanka");
        r.populate(1,"rajiv",list);
        return JSONUtil.randomObjectToJSONString(r);
        /*
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(r);
        }
        catch(Exception e){
            return e.getStackTrace().toString()+"\n\n"+e.getMessage();
        }
        */
    }
}
