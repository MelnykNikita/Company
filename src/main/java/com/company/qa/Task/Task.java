package com.company.qa.Task;

import java.util.Random;

public class Task {

    private int hoursPerTask;
    private String name;

    public Task(String name) {
        this.hoursPerTask = new Random().nextInt(2) + 1;
        this.name = name;
    }

    public int getHoursPerTask() {
        return hoursPerTask;
    }

    public String getName() {
        return name;
    }
}
