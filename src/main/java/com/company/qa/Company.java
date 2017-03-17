package com.company.qa;

import com.company.qa.Positions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Company {

    private int amountOfEmployees;
    private List<Employee> employeeList;
    private Chief chief;

    Company(){

        employeeList = new ArrayList<Employee>();

        chief = new Chief();
        employeeList.add(new Employee(chief));
        Accountant accountant = new Accountant();
        employeeList.add(new Employee(accountant));

        this.amountOfEmployees = new Random().nextInt(90) + 8; //Addition of employees
        for (int i = 1; i <= amountOfEmployees; i++) {
            employeeList.add(new Employee());
        }
    }

    public void chiefGivesTasksForEmployees() {
        chief.giveTask(employeeList); //Chief gives tasks for employees
    }

    public void setCurrentTasksForEmployees() {
        for (Employee employee: employeeList) {
            if (employee.getWorkHoursPerWeek() != employee.getWorkedHours()) {
                employee.setCurrentTask();
            }
            else {
                                            //TODO give tasks for freelancers
            }
        }
    }

    public void incrementWorkedHours() {
        for (Employee employee: employeeList) {
            if (employee.getWorkHoursPerWeek() >= employee.getWorkedHours()) {
                employee.incrementWorkedHours();
            }

        }
    }

    public int getAmountOfEmployees(){
        return amountOfEmployees;
    }

    public List<Employee> getEmployeeList(){
        return employeeList;
    }

}
