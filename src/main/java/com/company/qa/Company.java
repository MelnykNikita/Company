package com.company.qa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Company {

    private int amountOfEmployees;
    private List<Employee> employeeList;

    Company(){

        employeeList = new ArrayList<Employee>();

        this.amountOfEmployees = new Random().nextInt(90) + 10; //Addition of employees
        for (int i = 1; i <= amountOfEmployees; i++){
            employeeList.add(new Employee());

        }
    }

    public int getAmountOfEmployees(){
        return amountOfEmployees;
    }

    public List<Employee> getEmployeeList(){
        return employeeList;
    }
}
