package hibernate.dao;

import hibernate.model.Student;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

/**
 * Created by EZDI\manjunath.y on 5/2/16.
 */
@ComponentScan
public interface StudentSaver {
    public void saveStudent(Student s);
    public Student getStudentByRollNum(int rollNum);
    public List<Student> getAllStudents();
    public List<Student> getStudentsByGrade(int grade);
    public List<Student> getStudentsByQuery(String query);
}
