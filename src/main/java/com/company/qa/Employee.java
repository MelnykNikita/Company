package com.company.qa;

import com.company.qa.Helper.NameGenerator;
import com.company.qa.Positions.*;
import com.company.qa.Task.Task;
import java.util.*;

public class Employee {

    private String name;
    private int maxWorkHoursPerWeek;
    private int actualWorkHoursPerWeek = 0;
    private int maxWorkHoursPerMonth;
    private int actualWorkHoursPerMonth = 0;
    private int amountOfPositions;
    private List<Task> taskList = new ArrayList<Task>();
    private Iterator<Task> iterator = taskList.iterator();
    private int workedHours = 0;
    private int workedHoursIT = 0;
    private int index = 0;
    private int workedHoursAsProgrammer = 0;
    private int workedHoursAsDesigner = 0;
    private int workedHoursAsTester = 0;
    private int salary = 0;

    private Set<Position> positionList;
    private Programmer programmer;
    private Designer designer;
    private Tester tester;
    private Manager manager;

    private Set<Responsible> responsibilities;

    Employee() {

        name = NameGenerator.generateName();
        positionList = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();

        programmer = new Programmer();
        designer = new Designer();
        tester = new Tester();
        manager = new Manager();

        this.maxWorkHoursPerWeek = new Random().nextInt(6) + 35; //Setting of MAX work-hours per week
        this.maxWorkHoursPerMonth = 4 * maxWorkHoursPerWeek;

        this.amountOfPositions = new Random().nextInt(2) + 1; //Addition of positions for employee
        for (int i = 1; i <= amountOfPositions; i++) {
            int numberForPosition = new Random().nextInt(4) + 1;
            positionList.add(getSelectedPosition(numberForPosition));
            responsibilities.add(getSelectedResponsibility(numberForPosition));
        }
    }

    Employee(Chief chief) {
        name = NameGenerator.generateName();
        positionList = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positionList.add(chief);
        this.maxWorkHoursPerWeek = 40;
        this.maxWorkHoursPerMonth = 4 * maxWorkHoursPerWeek;
    }

    Employee(Accountant accountant) {
        name = NameGenerator.generateName();
        positionList = new HashSet<Position>();
        responsibilities = new HashSet<Responsible>();
        positionList.add(accountant);
        responsibilities.add(accountant);
        this.maxWorkHoursPerWeek = 40;
        this.maxWorkHoursPerMonth = 4 * maxWorkHoursPerWeek;
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

        if (iterator.hasNext() && index < taskList.size()) {

            if (index == 0 || !(taskList.get(index).isTaskExecuted())){
                Task task = taskList.get(index); //TODO Refactoring
                task.setCurrentTask(true);
                task.incrementWorkedHoursPerTask();
                incrementWorkedHoursIT(task);
                incrementWorkedHoursByITPosition(task);
                incrementWorkHoursPerWeek();
            }
            if (taskList.get(index).isTaskExecuted()) {
                index++;
            }
        }
    }

    public int getMaxWorkHoursPerWeek() {
        return maxWorkHoursPerWeek;
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

    public void incrementWorkHoursPerWeek() {
        this.actualWorkHoursPerWeek++;
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
        int sum = 0;
        for (Task task : getTaskList()) {
            sum += task.getHoursPerTask();
        }
        if (sum < maxWorkHoursPerMonth) {
            return true;
        }
        else {
            return false;
        }
    }

    public void addTask(Task task) {
        for (Responsible responsibility: getResponsibilities()) {
            if (task.isMatchableWithResponsibility(responsibility)) {
                getTaskList().add(new Task(task.getName()));
            }
        }
    }

    public int getMaxWorkHoursPerMonth() {
        return maxWorkHoursPerMonth;
    }

    public void setWeekSalary() {
        for (Position position: positionList) {
            if (position instanceof Programmer) {
                this.salary += position.getSalaryRate() * workedHoursAsProgrammer;
            }
            if (position instanceof Designer) {
                this.salary += position.getSalaryRate() * workedHoursAsDesigner;
            }
            if (position instanceof Tester) {
                this.salary += position.getSalaryRate() * workedHoursAsTester;
            }
            else if (position instanceof Chief
                    || position instanceof Accountant
                    || position instanceof Manager) {
                this.salary += position.getSalaryRate() / 4;
            }
        }

        this.workedHoursAsProgrammer = 0;
        this.workedHoursAsDesigner = 0;
        this.workedHoursAsTester = 0;
    }

    public int getSalary() {
        return salary;
    }

    public String positionToString() {
        String str = "";
        for (Position position: positionList) {
            str += position.getNameOfPosition() + " ";
        }
        return str;
    }

    public String toString() {
        return name;
    }
}
