package config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by EZDI\manjunath.y on 2/2/16.
 */
public class SpringApplicationContext {
    private static ApplicationContext applicationContext;

    public synchronized static ApplicationContext getApplicationContext(){
        if(applicationContext == null){
            applicationContext = new ClassPathXmlApplicationContext("/WEB-INF/spring-servlet.xml");
        }
        return applicationContext;
    }
}
