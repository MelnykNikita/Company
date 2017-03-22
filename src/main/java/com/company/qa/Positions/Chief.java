package com.company.qa.Positions;

import com.company.qa.Employee;
import com.company.qa.Freelancer;
import com.company.qa.Task.Task;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Chief implements Position {

    private int amountOfGivenTasks;

    private Set<Task> ChiefsTaskList;
    private Task taskForTesters = new Task("Test program");
    private Task taskForProgrammers = new Task("Write code");
    private Task taskForManagers = new Task("Sell services");
    private Task taskForDesigners = new Task("Draw layout");
    private Task taskForAccountant = new Task("Create report");


    public Chief() {
        ChiefsTaskList = new HashSet<Task>();
        addTasksToList();
    }

    public void giveTaskForEmployeesOrFreelancers(List<Employee> employeeList, List<Freelancer> freelancerList) { //TODO add freelancers
        amountOfGivenTasks = new Random().nextInt(2) + 1; //Amount of given tasks for every employee
        for (int i = 1; i <= amountOfGivenTasks; i++) {
            for (Task task: ChiefsTaskList) {
                for (Employee employee: employeeList) {
                    if (employee.isAvailable()) {
                        employee.addTask(new Task(task.getName()));
                    }
                    else {
                        for (Freelancer freelancer: freelancerList) {
                            if (freelancer.isAvailable()) {
                                freelancer.addTask(new Task(task.getName()));
                            }
                        }
                    }
                }
            }
        }
    }

    public String getNameOfPosition() {
        return "Chief";
    }

    public int getSalaryRate() {
        return 2000;
    }

    private void addTasksToList() {
        ChiefsTaskList.add(taskForTesters);
        ChiefsTaskList.add(taskForProgrammers);
        ChiefsTaskList.add(taskForManagers);
        ChiefsTaskList.add(taskForDesigners);
        ChiefsTaskList.add(taskForAccountant);
    }
}
