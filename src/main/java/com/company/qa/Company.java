package com.company.qa;

import com.company.qa.Positions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Company {

    private int amountOfEmployees;
    private List<Employee> employeeList;
    private List<Freelancer> freelancerList;
    private Chief chief;
    private Accountant accountant;

    Company(){

        employeeList = new ArrayList<Employee>();
        freelancerList = new ArrayList<Freelancer>();

        chief = new Chief();
        employeeList.add(new Employee(chief));
        accountant = new Accountant();
        employeeList.add(new Employee(accountant));

        this.amountOfEmployees = new Random().nextInt(90) + 10; //Addition of employees
        for (int i = 1; i <= amountOfEmployees; i++) {
            employeeList.add(new Employee());
        }

        freelancerList.add(new Freelancer(new Accountant())); //Addition of freelancers
        freelancerList.add(new Freelancer(new Manager()));
        freelancerList.add(new Freelancer(new Programmer()));
        freelancerList.add(new Freelancer(new Designer()));
        freelancerList.add(new Freelancer(new Tester()));
    }

    public void chiefGivesTasksForEmployees() {
        freelancerList = chief.giveTaskForEmployeesOrFreelancers(employeeList, freelancerList);
    }

    public void payWeekSalary() {
        accountant.payWeekSalary(employeeList, freelancerList);
    }

    public void accountantMakesMonthlyReport() {
        try {
            accountant.makeMonthlyReport(employeeList, freelancerList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCurrentTasksForEmployees() {
        for (Employee employee: employeeList) {
            if (employee.getMaxWorkHoursPerMonth() > employee.getWorkedHours()) {
                employee.setCurrentTask();
            }
        }
       for (Freelancer freelancer: freelancerList) {
           if (freelancer.getWorkHoursPerMonth() > freelancer.getWorkedHours()) {
               freelancer.setCurrentTask();
           }
       }
    }

    public void incrementWorkedHours() {
        for (Employee employee: employeeList) {
            if (employee.getMaxWorkHoursPerMonth() > employee.getWorkedHours()) {
                employee.incrementWorkedHours();
            }
        }
    }
}
