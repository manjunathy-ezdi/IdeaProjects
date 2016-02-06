package com.springapp.mvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springapp.hibernate.dataObject.Student;
import com.springapp.hibernate.transaction.StudentSaver;
import com.springapp.util.JSONUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by EZDI\manjunath.y on 29/1/16.
 */
@Controller
@RequestMapping("/hibernateTest")
public class HibernateTestController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getInfo(@RequestParam int rollNum) throws JsonProcessingException{
        Student stud = new StudentSaver().getStudent(rollNum);
        return JSONUtil.studentToJSONString(stud);
    }

}
