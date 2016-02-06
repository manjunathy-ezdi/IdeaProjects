package com.springapp.hibernate.transaction;

import com.springapp.hibernate.dataObject.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by EZDI\manjunath.y on 29/1/16.
 */
@ComponentScan
@Component
public class StudentSaver {
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    private SessionFactory sessionFactory;

    public StudentSaver(){
        init();
    }

    private void init(){
        /*
        if(studentFactory == null){
            studentFactory = config.sessionFactory().getObject();
        }
        */
    }

/*
    private void initOld(){
        if(studentFactory == null) {
            Configuration configuration = new Configuration().configure();
            ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder().applySettings(configuration.getProperties());
            studentFactory = configuration.buildSessionFactory(serviceRegistryBuilder.buildServiceRegistry());
        }
        if(config == null){
            config = new HibernateConfig();
        }
    }
*/

    public Student getStudent(int rollNum){
        if(sessionFactory == null){
            /*Student stud = new Student();
            LocalSessionFactoryBean localSessionFactoryBean = config.sessionFactory();
            if(localSessionFactoryBean == null){
                stud.setName("Buhuhuuhu 2.  :(");
            }
            else{
                sessionFactory = localSessionFactoryBean.getObject();
                if(sessionFactory == null){
                    stud.setName("buhbuhhuuash 3 :( ");
                }
            }
            return  stud;
            */
            return null;
        }
        else {
            Session session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();
            List<Student> studentList = session.createSQLQuery("select * FROM Student where rollNum=" + rollNum).list();
            tx.commit();
            session.close();
            if (studentList == null || studentList.size() < 1) return null;
            else return studentList.get(0);
        }
    }



    public void saveStudent(Student stud) {
        //HibernateTransactionManager txMgr = config.transactionManager(studentFactory);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(stud);
        tx.commit();
        session.close();
        session.flush();
    }

}
