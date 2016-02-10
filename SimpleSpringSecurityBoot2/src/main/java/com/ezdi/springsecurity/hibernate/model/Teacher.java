package com.ezdi.springsecurity.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by EZDI\manjunath.y on 9/2/16.
 */
@Entity
@Table(name="Teacher")
public class Teacher {

    @Column
    @Id
    private int id;

    @Column
    private String name;

    @Column
    private String subjectMajor;

    @Column
    private String subjectMinor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubjectMajor() {
        return subjectMajor;
    }

    public void setSubjectMajor(String subjectMajor) {
        this.subjectMajor = subjectMajor;
    }

    public String getSubjectMinor() {
        return subjectMinor;
    }

    public void setSubjectMinor(String subjectMinor) {
        this.subjectMinor = subjectMinor;
    }
}
