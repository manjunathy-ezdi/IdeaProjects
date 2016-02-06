package application;

import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by EZDI\manjunath.y on 5/2/16.
 */
@SpringBootApplication
public class MyApplication {

    /*
    public static void main(String args[]){
        //ApplicationContext applicationContext = SpringApplication.run(MyApplication.class, args);
        //ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
        //ApplicationContext applicationContext = SpringApplication.run(BeanConfiguration.class, args);

        ApplicationContext applicationContext = SpringApplication.run(MyApplication.class);

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
    */

}
