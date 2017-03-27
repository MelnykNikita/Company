package com.company.qa;

import com.company.qa.Positions.*;
import com.company.qa.Task.Task;

import java.util.*;

public class Freelancer {

    private List<Task> taskList = new ArrayList<Task>();
    private Iterator<Task> iterator = taskList.iterator();
    private int workHoursPerWeek = 15;
    private int workHoursPerMonth = 4 * workHoursPerWeek;
    private int workedHours = 0;
    private int index = 0;

    private Programmer programmer;
    private Designer designer;
    private Tester tester;
    private Manager manager;
    private Accountant accountant;
    private Set<Responsible> responsibilities;
    private Set<Position> positions;

    public Freelancer(Freelancer freelancer) {
        positions = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positions.add(freelancer.getOnePosition());
        responsibilities.add(freelancer.getOneResponsibility());
    }

    public Freelancer() {
        responsibilities = new HashSet<Responsible>();
        positions = new HashSet<Position>();

        programmer = new Programmer();
        designer = new Designer();
        tester = new Tester();
        manager = new Manager();
        accountant = new Accountant();

        int numberForPosition = new Random().nextInt(5) + 1;
        responsibilities.add(getSelectedResponsibility(numberForPosition));
        positions.add(getSelectedPosition(numberForPosition));

    }

    Freelancer(Accountant accountant) {
        positions = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positions.add(accountant);
        responsibilities.add(accountant);
    }

    Freelancer(Tester tester) {
        positions = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positions.add(tester);
        responsibilities.add(tester);
    }

    Freelancer(Programmer programmer) {
        positions = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positions.add(programmer);
        responsibilities.add(programmer);
    }

    Freelancer(Designer designer) {
        positions = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positions.add(designer);
        responsibilities.add(designer);
    }

    Freelancer(Manager manager) {
        positions = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positions.add(manager);
        responsibilities.add(manager);
    }

    public void setCurrentTask() {
        if (iterator.hasNext() && index < taskList.size()) {
           if (index == 0 || !(taskList.get(index).isTaskExecuted())) {
               Task task = taskList.get(index); //TODO Refactoring
               task.setCurrentTask(true);
               task.incrementWorkedHoursPerTask();
               incrementWorkedHours();
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


    public int getWorkHoursPerWeek() {
        return workHoursPerWeek;
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

    public int getWorkHoursPerMonth() {
        return workHoursPerMonth;
    }
}
