package com.company.qa;

import com.company.qa.Positions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Company {

    private int amountOfEmployees;
    private int amountOfFreelancers;
    private List<Employee> employeeList;
    private List<Freelancer> freelancerList;
    private Chief chief;

    Company(){

        employeeList = new ArrayList<Employee>();
        freelancerList = new ArrayList<Freelancer>();

        chief = new Chief();
        employeeList.add(new Employee(chief));
        Accountant accountant = new Accountant();
        employeeList.add(new Employee(accountant));

        this.amountOfEmployees = new Random().nextInt(90) + 8; //Addition of employees
        for (int i = 1; i <= amountOfEmployees; i++) {
            employeeList.add(new Employee());
        }

        //TODO Delete all freelancers. Add one freelancer, if it needed. ???
        this.amountOfFreelancers = new Random().nextInt(40) + 10;
        for (int i = 1; i <= amountOfFreelancers; i++) {
            freelancerList.add(new Freelancer());
        }

    }

    public void chiefGivesTasksForEmployees() {
        chief.giveTaskForEmployeesOrFreelancers(employeeList, freelancerList);
    }

    public void setCurrentTasksForEmployees() {
        for (Employee employee: employeeList) {
            if (employee.getWorkHoursPerWeek() > employee.getWorkedHours()) {
                employee.setCurrentTask();
            }
            else {                                  //TODO give tasks for freelancers
               for (Freelancer freelancer: freelancerList) {
                   if (freelancer.getWorkHoursPerWeek() > freelancer.getWorkedHours()) {
                       freelancer.setCurrentTask(); // TODO
                   }
               }
            }
        }
    }

    public void incrementWorkedHours() {
        for (Employee employee: employeeList) {
            if (employee.getWorkHoursPerWeek() > employee.getWorkedHours()) {
                employee.incrementWorkedHours();
            }
            else {                                //TODO 

            }

        }
    }

    public int getAmountOfEmployees(){
        return amountOfEmployees;
    }

    public int getAmountOfFreelancers() {
        return amountOfFreelancers;
    }

    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    public  List<Freelancer> getFreelancerList() {
        return freelancerList;
    }
}
