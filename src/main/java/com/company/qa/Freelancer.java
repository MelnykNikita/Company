package com.company.qa;

import com.company.qa.Positions.*;
import com.company.qa.Task.Task;

import java.util.*;

public class Freelancer {

    private List<Task> taskList = new ArrayList<Task>();
    private Iterator<Task> iterator = taskList.iterator();
    private int workHoursPerWeek = 60;
    private int workedHours = 0;
    private int index = 0;

    private Programmer programmer;
    private Designer designer;
    private Tester tester;
    private Manager manager;
    private Accountant accountant;
    private Set<Responsible> responsibility;
    private Set<Position> position;

    /*Freelancer() {}*/ //TODO New constructor for freelancer

    Freelancer() {
        responsibility = new HashSet<Responsible>();
        position = new HashSet<Position>();

        programmer = new Programmer();
        designer = new Designer();
        tester = new Tester();
        manager = new Manager();
        accountant = new Accountant();

        int numberForPosition = new Random().nextInt(5) + 1;
        responsibility.add(getSelectedResponsibility(numberForPosition));
        position.add(getSelectedPosition(numberForPosition));

    }

    public void setCurrentTask() {
        if (iterator.hasNext()) {
            if (index == 0 || !(taskList.get(index).isTaskExecuted())) {
                Task task = taskList.get(index); //TODO Refactoring
                task.setCurrentTask(true);
                task.incrementWorkedHoursPerTask();
            }
            if (taskList.get(index).isTaskExecuted()) {
                index++;
            }
        }
    }

    private Position getSelectedPosition(int numberForPosition) {

        switch (numberForPosition) {
            case 1:
                return programmer;
            case 2:
                return designer;
            case 3:
                return tester;
            case 4:
                return manager;
            case 5:
                return accountant;
            default:
                return null;
        }
    }

    private Responsible getSelectedResponsibility(int numberForPosition) {

        switch (numberForPosition) {
            case 1:
                return programmer;
            case 2:
                return designer;
            case 3:
                return tester;
            case 4:
                return manager;
            case 5:
                return accountant;
            default:
                return null;
        }
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public Set<Responsible> getResponsibilities() {
        return responsibility;
    }

    public Set<Position> getPosition() {
        return position;
    }

    public void incrementWorkedHours() {
        this.workedHours++;
    }

    public int getWorkHoursPerWeek() {
        return workHoursPerWeek;
    }
}
