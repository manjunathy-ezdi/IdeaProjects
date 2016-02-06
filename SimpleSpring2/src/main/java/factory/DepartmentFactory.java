package factory;

import objs.Department;
import objs.Employee;

/**
 * Created by EZDI\manjunath.y on 1/2/16.
 */
public class DepartmentFactory {

    private static int depIds=2;

    public static Department getDepartment(int id){
        return new Department("YouShallNotPass",id,new Employee(101,"Athena"));
    }

    public static Department makeDepartment(){
        depIds++;
        return new Department(depIds+"",depIds,new Employee(100,"Sparta"));
    }
}
