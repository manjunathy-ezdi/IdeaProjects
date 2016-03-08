package com.ezdi.springsecurity.config;

import com.ezdi.springsecurity.hibernate.dao.StudentSaver;
import com.ezdi.springsecurity.hibernate.dao.implementation.StudentSaverImpl;
import com.ezdi.springsecurity.service.StudentService;
import com.ezdi.springsecurity.service.implementation.StudentServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;

/**
 * Created by EZDI\manjunath.y on 8/2/16.
 */
@ComponentScan(basePackages={"com.ezdi.springsecurity.config","com.ezdi.springsecurity.controller","com.ezdi.springsecurity.hibernate","com.ezdi.springsecurity.service"})
@SpringBootApplication
@EnableWebMvc
public class MySpringSecurityApplication {



    @Bean(name = "studentSaver")
    public StudentSaver studentSaver(SessionFactory sessionFactory){
        StudentSaverImpl studentSaver = new StudentSaverImpl();
        studentSaver.setSessionFactory(sessionFactory);
        return studentSaver;
    }

    @Bean
    public StudentService studentService(StudentSaver studentSaver){
        StudentServiceImpl studentService = new StudentServiceImpl();
        studentService.setStudentSaver(studentSaver);
        return studentService;
    }

    /*
    public static void main(String args[]){
        //ApplicationContext applicationContext = SpringApplication.run(MyApplication.class, args);
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        //ApplicationContext applicationContext = SpringApplication.run(BeanConfiguration.class, args);

        //SpringApplication springApplication = new SpringApplication(BeanConfiguration.class);

        ApplicationContext applicationContext = SpringApplication.run(MySpringSecurityApplication.class);

        String[] beanNames = applicationContext.getBeanDefinitionNames();
        System.out.println("The beans configured (automatically by spring-boot!!) are: ");
        if(beanNames != null){
            System.out.println("NUMBER : "+beanNames.length);
            Arrays.sort(beanNames);
            for(String each: beanNames){
                System.out.println(each);
            }
        }
        else{
            System.out.println("beanNames is NULL");
        }

    }
    */

}
