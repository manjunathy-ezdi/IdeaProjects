package controller;

import hibernate.dao.StudentSaver;
import hibernate.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

/**
 * Created by EZDI\manjunath.y on 5/2/16.
 */
@RestController
@ComponentScan
public class StudentController {

    @Autowired
    private ApplicationContext applicationContext;

    @RequestMapping(name="/student",method = RequestMethod.GET)
    @ResponseBody
    public Student getStudent(@RequestParam(name="rollNum") int rollNum){
        if(applicationContext == null){
            System.out.println("Application Context is null");
            return null;
        }
        StudentSaver studentSaver = (StudentSaver) applicationContext.getBean("studentSaver");
        if(studentSaver == null) {
            return (Student)applicationContext.getBean("studentNullSessionFactory");
        }
        else{
            return studentSaver.getStudentByRollNum(rollNum);
        }
    }
}
