package com.company.qa.Positions;

import com.company.qa.Employee;
import com.company.qa.Task.Task;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Chief implements Position, Responsible {

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

    public String getNameOfResponsibility() {
        return "Give tasks";
    }

    public void giveTask(List<Employee> employeeList) {
        amountOfGivenTasks = new Random().nextInt(2) + 1; //Amount of given tasks for every employee
        for (int i = 1; i <= amountOfGivenTasks; i++) {
            for (Employee employee : employeeList) {
                for (Responsible responsible : employee.getResponsibilities()) {
                    for (Task task : ChiefsTaskList) {
                        if (task.getName().equalsIgnoreCase(responsible.getNameOfResponsibility())) {
                            employee.getTaskList().add(new Task(responsible));
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
