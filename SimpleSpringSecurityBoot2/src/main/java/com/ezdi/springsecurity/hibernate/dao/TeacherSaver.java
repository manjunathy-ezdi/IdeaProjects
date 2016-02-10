package com.ezdi.springsecurity.hibernate.dao;

import com.ezdi.springsecurity.hibernate.model.Teacher;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by EZDI\manjunath.y on 9/2/16.
 */
public interface TeacherSaver {
    public Teacher getTeacherById(int id);
    public void saveOrUpdate(Teacher teacher);
    public List<Teacher> getAllTeachers();
    public List<Teacher> getTeachersByQuery(Query query);
}
