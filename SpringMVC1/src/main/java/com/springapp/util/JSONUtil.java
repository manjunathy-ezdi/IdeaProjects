package com.springapp.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springapp.hibernate.dataObject.Student;
import com.springapp.misc.RandomObject;

/**
 * Created by EZDI\manjunath.y on 29/1/16.
 */
public class JSONUtil {

    public static String randomObjectToJSONString(RandomObject o) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }

    public static String studentToJSONString(Student o) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    }

    public static String test(){
        String ret="Initial";
        try {
            RandomObject r = new RandomObject();
            r.populate(1, "x", null);
            ret = JSONUtil.randomObjectToJSONString(r);
        }
        catch(JsonProcessingException h){
            ret = "JsonProcessingException";
        }
        return ret;
    }
}
