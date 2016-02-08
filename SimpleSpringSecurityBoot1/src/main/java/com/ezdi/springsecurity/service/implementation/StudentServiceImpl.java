package com.ezdi.springsecurity.service.implementation;

import com.ezdi.springsecurity.hibernate.dao.StudentSaver;
import com.ezdi.springsecurity.hibernate.model.Student;
import com.ezdi.springsecurity.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by EZDI\manjunath.y on 8/2/16.
 */
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentSaver studentSaver;

    public StudentSaver getStudentSaver() {
        return studentSaver;
    }

    public void setStudentSaver(StudentSaver studentSaver) {
        this.studentSaver = studentSaver;
    }

    @Override
    public void saveOrUpdateStudent(Student student) {
        studentSaver.saveOrUpdateStudent(student);
    }

    @Override
    public Student getStudentByRollNum(int rollNum) {
        return studentSaver.getStudentByRollNum(rollNum);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentSaver.getAllStudents();
    }
}
