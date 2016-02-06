package main.java;

/**
 * Created by EZDI\manjunath.y on 1/2/16.
 */
public class Employee {

    private String name;

    public void displayInfo(){
        System.out.println("Hello "+name+"!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
