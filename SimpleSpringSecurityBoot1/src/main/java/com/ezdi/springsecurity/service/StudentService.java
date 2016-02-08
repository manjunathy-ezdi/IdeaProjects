package com.ezdi.springsecurity.service;

import com.ezdi.springsecurity.hibernate.model.Student;

import java.util.List;

/**
 * Created by EZDI\manjunath.y on 8/2/16.
 */
public interface StudentService {
    public void saveOrUpdateStudent(Student student);
    public Student getStudentByRollNum(int rollNum);
    public List<Student> getAllStudents();
}
