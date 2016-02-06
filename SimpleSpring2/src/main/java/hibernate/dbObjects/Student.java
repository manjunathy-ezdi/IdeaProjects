package hibernate.dbObjects;

import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by EZDI\manjunath.y on 1/2/16.
 */
@Component
@Entity
@Table(name="student")
public class Student {

    @Id
    @Column
    private int rollNum;
    @Column
    private String name;
    @Column(name="class")
    private int standard;
    @Column
    private String father;
    @Column
    private String mother;
    @Column
    private Date dob;

    public int getRollNum() {
        return rollNum;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStandard() {
        return standard;
    }

    public void setStandard(int standard) {
        this.standard = standard;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String toString(){
        String ret = "StudName: "+name+" ;; StudRollNum: "+rollNum+" ;; StudClass: "+standard+" ;; StudFather: "+father+" ;; StudMother: "+mother;
        if(dob != null) ret += " ;; StudDOB: "+dob.toString();
        return ret;
    }
}
