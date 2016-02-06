package config;

import hibernate.dao.StudentSaver;
import hibernate.dao.impl.StudentSaverImpl;
import hibernate.model.Student;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;


/**
 * Created by EZDI\manjunath.y on 5/2/16.
 */
@ComponentScan
@SpringBootApplication
@EnableWebMvc
public class BeanConfiguration {

    @Bean
    public Student getStudentNullApplicationContext(){
        Student student = new Student();
        student.setName("ApplicationContext is null");
        return student;
    }

    @Bean
    public Student getStudentNullSessionFactory(){
        Student student = getStudentNullApplicationContext();
        student.setName("SessionFactory is null");
        return  student;
    }

    @Bean(name="dataSource")
    public DataSource getDataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/hibtest");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("P@ssw0rd@123");
        return basicDataSource;
    }

    @Bean
    @Autowired
    public SessionFactory getSessionFactory(DataSource dataSource){
        //LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(getDataSource());
        LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource);
        localSessionFactoryBuilder.addAnnotatedClasses(Student.class);
        //localSessionFactoryBuilder.addProperties(getHibernateProperties());
        return localSessionFactoryBuilder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return properties;
    }

    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
}
    @Bean
    @Autowired
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }

    @Bean
    public StudentSaver getStudentSaver(SessionFactory sessionFactory){
        StudentSaverImpl studentSaver = new StudentSaverImpl();
        studentSaver.setSessionFactory(sessionFactory);
        return studentSaver;
    }


    public static void main(String args[]){
        //ApplicationContext applicationContext = SpringApplication.run(MyApplication.class, args);
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        //ApplicationContext applicationContext = SpringApplication.run(BeanConfiguration.class, args);

        //SpringApplication springApplication = new SpringApplication(BeanConfiguration.class);

        ApplicationContext applicationContext = SpringApplication.run(BeanConfiguration.class);

        System.out.println("The beans configured (automatically by spring-boot!!) are: ");
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        if(beanNames != null){
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
