package com.company.qa;

import com.company.qa.Positions.*;
import com.company.qa.Task.Task;

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

        this.amountOfFreelancers = new Random().nextInt(150) + 1;
        for (int i = 1; i <= amountOfFreelancers; i++) {
            freelancerList.add(new Freelancer());
        }

    }

    public void chiefGivesTasksForEmployees() {
        chief.giveTask(employeeList); //Chief gives tasks for employees
    }

    public void setCurrentTasksForEmployees() {
        for (Employee employee: employeeList) {
            if (employee.getWorkHoursPerWeek() > employee.getWorkedHours()) {
                employee.setCurrentTask();
            }
            else {
               giveTasksForFreelancers();             //TODO give tasks for freelancers
            }
        }
    }

    public void incrementWorkedHours() {
        for (Employee employee: employeeList) {
            if (employee.getWorkHoursPerWeek() > employee.getWorkedHours()) {
                employee.incrementWorkedHours();
            }

        }
    }

    public void giveTasksForFreelancers() {     //TODO
        for (Employee employee : employeeList) {
            if (employee.getWorkHoursPerWeek() == employee.getWorkedHours()) {
                for (Task task : employee.getTaskList()) {
                    for (Freelancer freelancer : freelancerList) {
                        for (Responsible responsible : freelancer.getResponsibilities()) {
                            if (!(task.isTaskExecuted())
                                    && task.getName().equalsIgnoreCase(responsible.getNameOfResponsibility())) {
                                if (freelancer.getWorkedHours() != freelancer.getWorkHoursPerWeek()) {
                                    freelancer.getTaskList().add(task);

                                }
                            }
                        }
                    }
                    task = null;
                }
            }
        }
    }

    public int getAmountOfEmployees(){
        return amountOfEmployees;
    }

    public List<Employee> getEmployeeList(){
        return employeeList;
    }

    public  List<Freelancer> getFreelancerList() {
        return freelancerList;
    }
}
