package com.ezdi.springsecurity.controller;

import com.ezdi.springsecurity.hibernate.model.Student;
import com.ezdi.springsecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;

/**
 * Created by EZDI\manjunath.y on 8/2/16.
 */
@RestController
@RequestMapping(path="/")
public class StudentController {

    @Autowired
    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @RequestMapping(path="/student", method= RequestMethod.GET)
    @ResponseBody
    public Student getStudentByRollNum(@RequestParam(name="rollNum") int rollNum, HttpSession session, Principal principal){
        StudentService studentService = (StudentService)applicationContext.getBean("studentService");
        //System.out.println("Student "+rollNum+" got in session "+session.getId()+" by user "+principal.getName());
        return studentService.getStudentByRollNum(rollNum);
    }

    @RequestMapping(path="/student", method=RequestMethod.POST)
    @ResponseBody
    public String addStudent(Student s, HttpSession session, Principal principal){
        StudentService studentService = (StudentService)applicationContext.getBean("studentService");
        studentService.saveOrUpdateStudent(s);
        //return "Student updated in session "+session.getId()+" by user "+principal.getName();
        return "Student updated";
    }

    /*
    @RequestMapping(path="/student", method= RequestMethod.GET)
    @ResponseBody
    public Student getStudentByRollNum(@RequestParam(name="rollNum") int rollNum){
        StudentService studentService = (StudentService)applicationContext.getBean("studentService");
        return studentService.getStudentByRollNum(rollNum);
    }

    @RequestMapping(path="/student", method=RequestMethod.POST)
    @ResponseBody
    public void addStudent(Student s){
        StudentService studentService = (StudentService)applicationContext.getBean("studentService");
        studentService.saveOrUpdateStudent(s);
    }
    */
}
