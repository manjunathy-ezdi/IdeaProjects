package com.ezdi.springsecurity.controller;

import com.ezdi.springsecurity.hibernate.model.Teacher;
import com.ezdi.springsecurity.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * Created by EZDI\manjunath.y on 9/2/16.
 */
@RestController
@RequestMapping(path="/")
public class TeacherController {

    @Autowired
    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @RequestMapping(path= "/teacher", method = RequestMethod.GET)
    @ResponseBody
    public Teacher getTeacherById(@RequestParam(name="id") int id){
        TeacherService teacherService = (TeacherService)applicationContext.getBean("teacherService");
        return teacherService.getTeacherById(id);
    }
}
