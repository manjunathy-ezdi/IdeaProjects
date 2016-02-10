package com.ezdi.springsecurity.config;

import com.ezdi.springsecurity.hibernate.model.Teacher;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by EZDI\manjunath.y on 9/2/16.
 */
@Configuration
public class MyServletConfig {

    @Bean(name= DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME)
    public DispatcherServlet dispatcherServlet(ApplicationContext applicationContext) {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.setParent(applicationContext);
        //webContext.register(BeanConfiguration.class);
        // webContext.refresh();
        return new DispatcherServlet(webContext);
    }

    @Bean(name=DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME)
    public ServletRegistrationBean dispatcherServletRegistration(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(dispatcherServlet);
        //ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        //servletRegistrationBean.setServlet(dispatcherServlet);
        servletRegistrationBean.addUrlMappings("/");
        servletRegistrationBean.addUrlMappings("*.jsp");
        servletRegistrationBean.setLoadOnStartup(1);
        servletRegistrationBean.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
        return servletRegistrationBean;
    }

    @Bean(name = "viewResolver")
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    //@Primary
    @Bean(name="serviceDataSource")
    //@Resource(name="dataSource")
    public DataSource serviceDataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        System.out.println("YAJI: Created dataSource"+basicDataSource);
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl("jdbc:mysql://localhost:3306/hibtest2");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("P@ssw0rd@123");
        System.out.println("YAJI: Returning dataSource");
        return basicDataSource;
    }

    @Bean
    public SessionFactory sessionFactory(DataSource serviceDataSource){
        System.out.println("YAJI: SESSIONFACTORY: "+serviceDataSource);
        LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(serviceDataSource);
        //LocalSessionFactoryBuilder localSessionFactoryBuilder = new LocalSessionFactoryBuilder(dataSource());
        localSessionFactoryBuilder.addAnnotatedClasses(Teacher.class);
        localSessionFactoryBuilder.addProperties(getHibernateProperties());
        return localSessionFactoryBuilder.buildSessionFactory();
    }

    private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        return properties;
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
        return transactionManager;
    }
}
