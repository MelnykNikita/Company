package com.company.qa;

import com.company.qa.Positions.*;
import com.company.qa.Task.Task;

import java.util.*;

public class Freelancer {

    private List<Task> taskList = new ArrayList<Task>();
    private Iterator<Task> iterator = taskList.iterator();
    private int maxWorkHoursPerWeek = 15;
    private int actualWorkHoursPerWeek = 0;
    private int workHoursPerMonth = 4 * maxWorkHoursPerWeek;
    private int workedHours = 0;
    private int index = 0;
    private int salary = 0;
    private int salaryRate;

    private Set<Responsible> responsibilities;
    private Set<Position> positions;

    public Freelancer(Freelancer freelancer) {
        positions = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positions.add(freelancer.getOnePosition());
        responsibilities.add(freelancer.getOneResponsibility());
        salaryRate = freelancer.getSalaryRate();
    }

    Freelancer(Accountant accountant) {
        positions = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positions.add(accountant);
        responsibilities.add(accountant);
        salaryRate = 5;
    }

    Freelancer(Tester tester) {
        positions = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positions.add(tester);
        responsibilities.add(tester);
        salaryRate = 6;
    }

    Freelancer(Programmer programmer) {
        positions = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positions.add(programmer);
        responsibilities.add(programmer);
        salaryRate = 10;
    }

    Freelancer(Designer designer) {
        positions = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positions.add(designer);
        responsibilities.add(designer);
        salaryRate = 7;
    }

    Freelancer(Manager manager) {
        positions = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positions.add(manager);
        responsibilities.add(manager);
        salaryRate = 8;
    }

    public void setCurrentTask() {
        if (iterator.hasNext() && index < taskList.size()) {
           if (index == 0 || !(taskList.get(index).isTaskExecuted())) {
               Task task = taskList.get(index); //TODO Refactoring
               task.setCurrentTask(true);
               task.incrementWorkedHoursPerTask();
               incrementWorkedHours();
               this.actualWorkHoursPerWeek++;
           }
           if (taskList.get(index).isTaskExecuted()) {
               index++;
           }
        }
    }

    public void incrementWorkedHours() {
        this.workedHours++;
    }

    public boolean isAvailable() {
        if (taskList.isEmpty()) {
            return true;
        }
        if (!taskList.isEmpty() && getTaskList().get(0).isTaskExecuted()) {
            return true;
        }
        else {
            return false;
        }
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public Set<Responsible> getResponsibilities() {
        return responsibilities;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    public int getMaxWorkHoursPerWeek() {
        return maxWorkHoursPerWeek;
    }

    public void addTask(Task task) {
        for (Responsible responsibility: getResponsibilities()) {
            if (task.isMatchableWithResponsibility(responsibility)) {
                getTaskList().add(new Task(task.getName()));
            }
        }
    }

    public Responsible getOneResponsibility() {
        for (Responsible responsibility: responsibilities) {
            return responsibility;
        }
        return null;
    }

    public Position getOnePosition() {
        for (Position position: positions) {
            return position;
        }
        return null;
    }

    public int getWorkHoursPerMonth() {
        return workHoursPerMonth;
    }

    public int getSalary() {
        return salary;
    }

    public int getSalaryRate() {
        return salaryRate;
    }

    public void setWeekSalary() {
        this.salary += salaryRate * actualWorkHoursPerWeek;
        this.actualWorkHoursPerWeek = 0;
    }
}
