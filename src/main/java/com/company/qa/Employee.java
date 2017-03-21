package com.company.qa;

import com.company.qa.Positions.*;
import com.company.qa.Task.Task;
import java.util.*;

public class Employee {

    private int workHoursPerWeek;
    private int amountOfPositions;
    private List<Task> taskList = new ArrayList<Task>();
    private Iterator<Task> iterator = taskList.iterator();
    private int workedHours = 0;
    private int workedHoursIT = 0;
    private int index = 0;
    private int workedHoursAsProgrammer = 0;
    private int workedHoursAsDesigner = 0;
    private int workedHoursAsTester = 0;

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
        this.workHoursPerWeek = 40;
    }

    Employee(Accountant accountant) {
        positionList = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positionList.add(accountant);
        responsibilities.add(accountant);
        this.workHoursPerWeek = 40;
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

    private void incrementWorkedHoursIT(Task task) {
        for (Responsible responsible: getResponsibilities())
            if (task.getName().equalsIgnoreCase(responsible.getNameOfResponsibility())
                    && responsible instanceof IT) {
                this.workedHoursIT++;
            }
    }

    private void incrementWorkedHoursByITPosition(Task task) {
        for (Responsible responsible: getResponsibilities()) {
            if (task.getName().equalsIgnoreCase(responsible.getNameOfResponsibility())
                    && responsible instanceof Programmer) {
                this.workedHoursAsProgrammer++;
            }
            if (task.getName().equalsIgnoreCase(responsible.getNameOfResponsibility())
                    && responsible instanceof Designer) {
                this.workedHoursAsDesigner++;
            }
            if (task.getName().equalsIgnoreCase(responsible.getNameOfResponsibility())
                    && responsible instanceof Tester) {
                this.workedHoursAsTester++;
            }
        }
    }

    public void setCurrentTask() {
        if (iterator.hasNext()) {
            if (index == 0 || !(taskList.get(index).isTaskExecuted())){
                Task task = taskList.get(index); //TODO Refactoring
                task.setCurrentTask(true);
                task.incrementWorkedHoursPerTask();
                incrementWorkedHoursIT(task);
                incrementWorkedHoursByITPosition(task);
            }
            if (taskList.get(index).isTaskExecuted()) {
                index++;
            }
        }
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

    public int getWorkedHours() {
        return workedHours;
    }

    public void incrementWorkedHours() {
        this.workedHours++;
    }

    public int getWorkedHoursIT() {
        return workedHoursIT;
    }

    public int getWorkedHoursAsProgrammer() {
        return workedHoursAsProgrammer;
    }

    public int getWorkedHoursAsDesigner() {
        return workedHoursAsDesigner;
    }

    public int getWorkedHoursAsTester() {
        return workedHoursAsTester;
    }

    public boolean isAvailable() {
        if (!getTaskList().isEmpty()) {
            for (Task task: getTaskList()) {
                if (task.isCurrent()) {
                    return false;
                }
            }
        }
        return true;
    }

    public void addTask(Task task) {
        for (Responsible responsibility : getResponsibilities()) {
            if (task.isMatchableWithResponsibility(responsibility)) {
                getTaskList().add(new Task(task.getName()));
            }
        }
    }
}
