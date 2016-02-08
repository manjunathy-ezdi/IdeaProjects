package com.ezdi.springsecurity.hibernate.dao.implementation;

import com.ezdi.springsecurity.hibernate.dao.StudentSaver;
import com.ezdi.springsecurity.hibernate.model.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by EZDI\manjunath.y on 8/2/16.
 */
public class StudentSaverImpl implements StudentSaver {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void saveOrUpdateStudent(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(student);
        session.saveOrUpdate(student);
        tx.commit();
        session.close();
    }

    @Override
    public Student getStudentByRollNum(int rollNum) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Student student = (Student) session.get(Student.class, rollNum);
        tx.commit();
        session.close();
        return  student;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = null;
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Criteria criteria = session.createCriteria(Student.class);
        if(criteria != null) students = criteria.list();
        tx.commit();
        session.close();
        return students;
    }
}
