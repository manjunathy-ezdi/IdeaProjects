package com.ezdi.springsecurity.config;

import com.ezdi.springsecurity.hibernate.dao.TeacherSaver;
import com.ezdi.springsecurity.hibernate.dao.implementation.TeacherSaverImpl;
import com.ezdi.springsecurity.service.TeacherService;
import com.ezdi.springsecurity.service.implementation.TeacherServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

/**
 * Created by EZDI\manjunath.y on 9/2/16.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.ezdi.springsecurity"})
public class MySpringSecurityBootApplication {

    /*
    @Bean
    public JedisConnectionFactory connectionFactory() {
        JedisConnectionFactory jedisConnectionFectory = new JedisConnectionFactory();
//		jedisConnectionFectory.setHostName("localhost");
//		jedisConnectionFectory.setPort(6380);
        return jedisConnectionFectory;  // <2>
    }

    @Bean
    public HttpSessionStrategy httpSessionStrategy() {
        return new HeaderHttpSessionStrategy(); // <3>
    }
    */

    @Bean
    public TeacherSaver teacherSaver(SessionFactory sessionFactory){
        TeacherSaverImpl teacherSaver = new TeacherSaverImpl();
        teacherSaver.setSessionFactory(sessionFactory);
        return teacherSaver;
    }

    @Bean
    public TeacherService teacherService(TeacherSaver teacherSaver){
        TeacherServiceImpl teacherService = new TeacherServiceImpl();
        teacherService.setTeacherSaver(teacherSaver);
        return teacherService;
    }

    public static void main(String args[]){
        //ApplicationContext applicationContext = SpringApplication.run(MyApplication.class, args);
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        //ApplicationContext applicationContext = SpringApplication.run(BeanConfiguration.class, args);

        //SpringApplication springApplication = new SpringApplication(BeanConfiguration.class);

        ApplicationContext applicationContext = SpringApplication.run(MySpringSecurityBootApplication.class);

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


}
