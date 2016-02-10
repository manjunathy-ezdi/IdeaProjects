package com.ezdi.springsecurity.hibernate.dao.implementation;

import com.ezdi.springsecurity.hibernate.dao.TeacherSaver;
import com.ezdi.springsecurity.hibernate.model.Teacher;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by EZDI\manjunath.y on 9/2/16.
 */
public class TeacherSaverImpl implements TeacherSaver {

    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Teacher getTeacherById(int id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Teacher teacher = (Teacher)session.get(Teacher.class,id);
        tx.commit();
        session.close();
        return teacher;
    }

    @Override
    public void saveOrUpdate(Teacher teacher) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        tx.commit();
        session.saveOrUpdate(teacher);
        session.close();
    }

    @Override
    public List<Teacher> getAllTeachers() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Criteria cr = session.createCriteria(Teacher.class);
        List<Teacher> ret = cr.list();
        tx.commit();
        session.close();
        return ret;
    }

    @Override
    public List<Teacher> getTeachersByQuery(Query query) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        query.executeUpdate();
        List<Teacher> teacherList = query.getResultList();
        tx.commit();
        session.close();
        return teacherList;
    }
}
