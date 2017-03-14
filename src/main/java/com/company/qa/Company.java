package com.company.qa;

import com.company.qa.Positions.Accountant;
import com.company.qa.Positions.Chief;
import com.company.qa.Positions.Position;
import com.company.qa.Positions.Programmer;
import com.company.qa.Task.Task;

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

    public void setCurrentTasksForEmployees() {
        for (Employee employee: employeeList) {
            employee.setCurrentTask();
        }
    }

    public void chiefGivesTasksForEmployees() {
        chief.giveTask(employeeList); //Chief gives tasks for employees
    }

    public void incrementWorkedHours() {
        for (Employee employee: employeeList) {
            for (Task task: employee.getTaskList()) {
                /*for (Position position: employee.getPositionList())
                    if (position.getNameOfPosition() == new Programmer().getNameOfPosition()) //TODO IT interface
                        employee.setWorkedHours(100);*/
                if (task.getStatusOfTask() == true)
                task.incrementWorkedHoursPerTask();
            }
            employee.incrementWorkedHours();
            employee.removeExecutedTask();
        }
    }

    public int getAmountOfEmployees(){
        return amountOfEmployees;
    }

    public List<Employee> getEmployeeList(){
        return employeeList;
    }
}
