package hibernate.dao.impl;

import hibernate.dao.StudentSaver;
import hibernate.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by EZDI\manjunath.y on 5/2/16.
 */
public class StudentSaverImpl implements StudentSaver {
    SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveStudent(Student s) {
        Session session = sessionFactory.openSession();
    }

    @Override
    public Student getStudentByRollNum(int rollNum) {
        if(sessionFactory == null) return null;
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Student student = (Student)session.get(Student.class,rollNum);
        tx.commit();
        session.close();
        return  student;
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
    }

    @Override
    public List<Student> getStudentsByGrade(int grade) {
        return null;
    }

    @Override
    public List<Student> getStudentsByQuery(String query) {
        return null;
    }
}
