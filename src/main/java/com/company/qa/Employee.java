package com.company.qa;

import com.company.qa.Positions.*;

import java.util.*;

public class Employee {

    private int workHoursPerWeek;
    private int amountOfPositions;
    private Set<Position> positionList;
    private Programmer programmer;
    private Designer designer;
    private Tester tester;
    private Manager manager;


    Employee() {

        positionList = new HashSet<Position>();
        programmer = new Programmer();
        designer = new Designer();
        tester = new Tester();
        manager = new Manager();

        this.workHoursPerWeek = new Random().nextInt(6) + 35; //Setting of work-hours per week

        this.amountOfPositions = new Random().nextInt(2) + 1; //Addition of positions for employee
        for (int i = 1; i <= amountOfPositions; i++) {
            positionList.add(getSelectedPosition());

        }
    }

    Employee(Chief chief) {
        positionList = new HashSet<Position>();
        positionList.add(chief);
        this.workHoursPerWeek = 40;
    }

    Employee(Accountant accountant) {
        positionList = new HashSet<Position>();
        positionList.add(accountant);
        this.workHoursPerWeek = 40;
    }

    public int getWorkHoursPerWeek() {
        return workHoursPerWeek;
    }

    public Set<Position> getPositionList(){
        return positionList;
    }

    private Position getSelectedPosition() {

        int numberForPosition = new Random().nextInt(4) + 1;

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
