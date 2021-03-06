package com.company.qa.Positions;

import com.company.qa.Employee;
import com.company.qa.Freelancer;
import com.company.qa.Task.Task;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Chief implements Position {

    private int amountOfGivenTasks;

    private Set<Task> ChiefsTaskList;
    private Task taskForTesters = new Task("Test program");
    private Task taskForProgrammers = new Task("Write code");
    private Task taskForManagers = new Task("Sell services");
    private Task taskForDesigners = new Task("Draw layout");
    private Task taskForAccountant = new Task("Create report");

    private List<Task> taskListForFreelancers = new ArrayList<Task>();

    public Chief() {
        ChiefsTaskList = new HashSet<Task>();
        addTasksToList();
    }

    public List<Freelancer> giveTaskForEmployeesOrFreelancers
            (List<Employee> employeeList, List<Freelancer> freelancerList) { //TODO add freelancers

        List<Freelancer> list = new CopyOnWriteArrayList<Freelancer>(freelancerList);
        Iterator<Freelancer> freelancerIterator = list.iterator();

        for (Task task : ChiefsTaskList) {
            for (Employee employee : employeeList) {
                amountOfGivenTasks = new Random().nextInt(2) + 1;
                for (int i = 1; i <= amountOfGivenTasks; i++) {
                    if (employee.isAvailable()) {
                        employee.addTask(new Task(task.getName()));
                    }
                    else {
                        taskListForFreelancers.add(new Task(task.getName()));
                    }
                }
            }
        }

        List<Task> taskListForFrees = new CopyOnWriteArrayList<Task>(taskListForFreelancers);
        Iterator<Task> taskIterator = taskListForFreelancers.iterator();

        while (taskIterator.hasNext()) {
            Task task = taskIterator.next();

            while (freelancerIterator.hasNext()) {
                Freelancer freelancer = freelancerIterator.next();

                if (freelancer.isAvailable()) {
                    freelancer.addTask((new Task(task.getName())));
                    taskListForFrees.remove(task);
                } else {
                    Freelancer freelancer1 = new Freelancer(freelancer);
                    freelancer1.addTask(new Task(task.getName()));
                    list.add(freelancer1);
                    taskListForFrees.remove(task);
                }
            }
        }

        taskListForFreelancers = taskListForFrees;
        return list;
    }

    public String getNameOfPosition() {
        return "Chief";
    }

    public int getSalaryRate() {
        return 4000;
    }

    private void addTasksToList() {
        ChiefsTaskList.add(taskForTesters);
        ChiefsTaskList.add(taskForManagers);
        ChiefsTaskList.add(taskForDesigners);
        ChiefsTaskList.add(taskForAccountant);
        ChiefsTaskList.add(taskForProgrammers);
    }
}
