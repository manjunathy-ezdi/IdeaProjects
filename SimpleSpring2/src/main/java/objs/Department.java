package objs;

import java.util.List;
import java.util.Map;

/**
 * Created by EZDI\manjunath.y on 1/2/16.
 */
public class Department {

    private  String name;
    private int id;
    private Employee headOfDepartment;
    private List<Employee> employees;
    private Map<Integer,Employee> employeeMap;

    public String getName() {
        return name;
    }

    public Department(String name, int id, Employee headOfDepartment, Map<Integer,Employee> employeeMap) {
        this.name = name;
        this.id = id;
        this.headOfDepartment = headOfDepartment;
        this.employeeMap = employeeMap;
    }

    public Department(String name, int id, Employee headOfDepartment, List<Employee> employees) {
        this.name = name;
        this.id = id;
        this.headOfDepartment = headOfDepartment;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Department(String name, int id, Employee headOfDepartment) {
        this.name = name;
        this.id = id;
        this.headOfDepartment = headOfDepartment;
    }

    public Department(String name, int id) {
        this.name = name;
        this.id = id;

    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(Employee headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public Map<Integer, Employee> getEmployeeMap() {
        return employeeMap;
    }

    public void setEmployeeMap(Map<Integer, Employee> employeeMap) {
        this.employeeMap = employeeMap;
    }

    public void displayInfo(){
        System.out.println("Department ID: "+id+" ;; Dep Name: "+name+" ;; Employee: "+headOfDepartment.toString());
        displayEmployeesList();
        displayEmployeesMap();
    }

    public void displayEmployeesList(){
        if(employees != null) {
            System.out.println("The employees are:");
            for (Employee each : employees) {
                System.out.println(each.toString());
            }
        }
    }

    public void displayEmployeesMap(){
        if(employeeMap != null) {
            System.out.println("The employees MAP are:");
            for (Map.Entry<Integer, Employee> each : employeeMap.entrySet()) {
                System.out.println(each.getValue().toString());
            }
        }
    }
}
