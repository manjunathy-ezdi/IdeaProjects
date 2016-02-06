import hibernate.dbObjects.Student;
import hibernate.saver.StudentSaver;
import objs.Department;
import objs.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by EZDI\manjunath.y on 1/2/16.
 */
public class Test {

    private static ApplicationContext applicationContext;

    public static void test1(){
        Employee e = (Employee)applicationContext.getBean("employee1");
        e.displayInfo();
    }

    public static void test2(){
        Department d = (Department)applicationContext.getBean("department1");
        d.displayInfo();
    }

    public static void test3(){
        Department d = (Department)applicationContext.getBean("department2");
        d.displayInfo();
    }

    public static void test4(){
        Department d = (Department)applicationContext.getBean("departmentFactory");
        d.displayInfo();
    }

    public static void test5(){
        Department d = (Department)applicationContext.getBean("departmentFactory2");
        d.displayInfo();
    }

    public static void test6(){
        StudentSaver studentSaver = (StudentSaver)applicationContext.getBean("studentSaver");
        Student s = studentSaver.getByRollNum(1);
        System.out.println(s.toString());
    }

    public static void test7(){
        StudentSaver studentSaver = (StudentSaver) applicationContext.getBean("studentSaver");
        List<Student> studentList = studentSaver.getAllStudents();
        if(studentList == null) System.out.println("STUDENT LIST RETURNED NULL");
        else{
            for(Student each: studentList){
                System.out.println(each.toString());
            }
        }
    }

    public static Date makeDate(int year, int month, int date){
        Calendar cal = Calendar.getInstance();
        cal.set(year,month-1,date); //Calendar.JANUARY = 0
        return cal.getTime();
    }

    public static void test8(){
        Student s = new Student();
        s.setName("India");
        s.setDob(makeDate(1947,8,15));
        s.setFather("Bharat");
        s.setMother("Varsha");
        s.setStandard(69);
        s.setRollNum(3);
        StudentSaver sv = (StudentSaver)applicationContext.getBean("studentSaver");
        sv.saveOrUpdate(s);
    }

    public static void main(String args[]){
        applicationContext = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring-servlet.xml");
        //applicationContext = new ClassPathXmlApplicationContext("/WEB-INF/spring-servlet.xml");
        test8();
        test7();
    }
}
