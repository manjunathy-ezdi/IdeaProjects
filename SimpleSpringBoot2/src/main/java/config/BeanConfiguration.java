package config;

import hibernate.dao.StudentSaver;
import hibernate.dao.impl.StudentSaverImpl;
import hibernate.model.Student;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;


/**
 * Created by EZDI\manjunath.y on 5/2/16.
 */
@ComponentScan(basePackages = {"application","config","controller","hibernate"})
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

    @Bean(name = "studentSaver")
    public StudentSaver getStudentSaver(SessionFactory sessionFactory){
        StudentSaverImpl studentSaver = new StudentSaverImpl();
        studentSaver.setSessionFactory(sessionFactory);
        return studentSaver;
    }

    @Bean(name=DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet getDispatcherServlet(ApplicationContext applicationContext) {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.setParent(applicationContext);
        //webContext.register(BeanConfiguration.class);
        // webContext.refresh();
        return new DispatcherServlet(webContext);
    }

    @Bean(name=DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME)
    public ServletRegistrationBean dispatcherServletRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet);
        servletRegistrationBean.addUrlMappings("/");
        servletRegistrationBean.addUrlMappings("*.jsp");
        servletRegistrationBean.setLoadOnStartup(0);
        servletRegistrationBean.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
        return servletRegistrationBean;
    }


    public static void main(String args[]){
        //ApplicationContext applicationContext = SpringApplication.run(MyApplication.class, args);
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        //ApplicationContext applicationContext = SpringApplication.run(BeanConfiguration.class, args);

        //SpringApplication springApplication = new SpringApplication(BeanConfiguration.class);

        ApplicationContext applicationContext = SpringApplication.run(BeanConfiguration.class);

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
