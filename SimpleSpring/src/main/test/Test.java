package main.test;

import main.java.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by EZDI\manjunath.y on 1/2/16.
 */
public class Test {

    public static void main(String args[]){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml)");
        Employee e = (Employee) applicationContext.getBean("Employee");
        e.displayInfo();
    }
}
