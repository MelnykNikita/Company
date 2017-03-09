package com.company.qa.Task;

import com.company.qa.Positions.Responsible;

import java.util.Random;

public class Task {

    private int hoursPerTask;
    private String name;

    public Task(Responsible responsible) {
        this.hoursPerTask = new Random().nextInt(2) + 1;
        this.name = responsible.getNameOfResponsibility();
    }

    public Task(String name) {
        this.name = name;
    }

    public int getHoursPerTask() {
        return hoursPerTask;
    }

    public String getName() {
        return name;
    }
}
