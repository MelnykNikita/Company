package com.company.qa;

import com.company.qa.Positions.*;
import com.company.qa.Task.Task;
import java.util.*;

public class Employee {

    private int workHoursPerWeek;
    private int amountOfPositions;
    private List<Task> taskList = new ArrayList<Task>();
    private Task currentTask;
    private int workHoursPerTaskList;

    private Set<Position> positionList;
    private Programmer programmer;
    private Designer designer;
    private Tester tester;
    private Manager manager;

    private Set<Responsible> responsibilities;


    Employee() {

        positionList = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();

        programmer = new Programmer();
        designer = new Designer();
        tester = new Tester();
        manager = new Manager();

        this.workHoursPerWeek = new Random().nextInt(6) + 35; //Setting of MAX work-hours per week

        this.amountOfPositions = new Random().nextInt(2) + 1; //Addition of positions for employee
        for (int i = 1; i <= amountOfPositions; i++) {
            int numberForPosition = new Random().nextInt(4) + 1;
            positionList.add(getSelectedPosition(numberForPosition));
            responsibilities.add(getSelectedResponsibility(numberForPosition));
        }
    }

    Employee(Chief chief) {
        positionList = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positionList.add(chief);
        responsibilities.add(chief);
        this.workHoursPerWeek = 40;
    }

    Employee(Accountant accountant) {
        positionList = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positionList.add(accountant);
        responsibilities.add(accountant);
        this.workHoursPerWeek = 40;
    }

    public void setCurrentTask() { //TODO
        if (taskList != null)
        currentTask = taskList.get(0);
        else System.out.println("task list == NULL");
    }

    public Task getCurrentTask() {
        return currentTask;
    }

    public int getWorkHoursPerWeek() {
        return workHoursPerWeek;
    }

    public Set<Position> getPositionList(){
        return positionList;
    }

    public Set<Responsible> getResponsibilities() {
        return responsibilities;
    }

    public List<Task> getTaskList() {
        return taskList;
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
            default:
                return null;
        }
    }
}
