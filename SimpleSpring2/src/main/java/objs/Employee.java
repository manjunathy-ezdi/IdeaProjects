package objs;

import org.springframework.context.annotation.ComponentScan;

/**
 * Created by EZDI\manjunath.y on 1/2/16.
 */

@ComponentScan
public class Employee {

    private String name;
    private int id;
    private Department department;

    public Employee(Department department) {

        this.department = department;
    }

    public Employee(String name, int id, Department department) {

        this.name = name;
        this.id = id;
        this.department = department;
    }

    public Employee(){}

    public Employee(int id){
        this.id = id;
    }

    public Employee(String name){
        this.name=name;
    }

    public Employee(int id, String name){
        this.id = id;
        this.name = name;
    }

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void displayInfo(){
        System.out.println("Hello "+name+"!\nYour ID is "+id+".");
    }

    public String toString(){
        String ret = "EmpID: "+id+" ;; EmpName: "+name+" ;;";
        if(department!= null) ret+="EmpDepartment: "+department.getName();
        return ret;
    }
}
