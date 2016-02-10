package com.ezdi.springsecurity.service.implementation;

import com.ezdi.springsecurity.hibernate.dao.TeacherSaver;
import com.ezdi.springsecurity.hibernate.model.Teacher;
import com.ezdi.springsecurity.service.TeacherService;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by EZDI\manjunath.y on 9/2/16.
 */
public class TeacherServiceImpl implements TeacherService{
    private TeacherSaver teacherSaver;

    public TeacherSaver getTeacherSaver() {
        return teacherSaver;
    }

    public void setTeacherSaver(TeacherSaver teacherSaver) {
        this.teacherSaver = teacherSaver;
    }

    @Override
    public Teacher getTeacherById(int id) {
        return teacherSaver.getTeacherById(id);
    }

    @Override
    public void saveOrUpdate(Teacher teacher) {
        teacherSaver.saveOrUpdate(teacher);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherSaver.getAllTeachers();
    }

    @Override
    public List<Teacher> getTeachersByQuery(Query query) {
        return teacherSaver.getTeachersByQuery(query);
    }
}
