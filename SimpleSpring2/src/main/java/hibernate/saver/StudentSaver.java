package hibernate.saver;

import hibernate.dbObjects.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by EZDI\manjunath.y on 1/2/16.
 */
@Component
public class StudentSaver {
    /*
    private HibernateTemplate hibernateTemplate;

    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

    @Autowired
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }
    */

    //private HibernateTransactionManager hibernateTransactionManager;

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private void saveStudent(Student s){
        sessionFactory.getCurrentSession().save(s);
    }

    public void saveOrUpdate(Student s){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        //tx.begin();
        //session.persist(s);
        session.saveOrUpdate(s);
        tx.commit();
        session.close();
    }

    private void updateStudent(Student s){
        sessionFactory.getCurrentSession().update(s);
    }

    public Student getByRollNum(int rollNum){
        if(sessionFactory == null){
            System.out.println("SessionFactory is null.");
            return null;
        }
        else {
            Session session = sessionFactory.openSession();
            //Student student = (Student) sessionFactory.getCurrentSession().get(Student.class, id);
            session.beginTransaction();
            Student student = (Student)session.get(Student.class,rollNum);
            session.close();
            return student;
        }
    }

    public List<Student> getAllStudents(){
        Session session = sessionFactory.openSession();
        List<Student> students = session.createCriteria(Student.class).list();
        session.close();
        return  students;
    }

}
