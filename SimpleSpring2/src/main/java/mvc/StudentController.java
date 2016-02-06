package mvc;

import hibernate.dbObjects.Student;
import hibernate.saver.StudentSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by EZDI\manjunath.y on 2/2/16.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private ApplicationContext applicationContext;

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getStudentByID(@RequestParam int rollNum){
        StudentSaver sv = (StudentSaver)applicationContext.getBean("studentSaver");
        Student student = sv.getByRollNum(rollNum);
        return student.toString();
    }
}
