package com.company.qa.Task;

import com.company.qa.Positions.Responsible;
import java.util.Random;

public class Task {

    private int hoursPerTask;
    private String name;
    private boolean isCurrent;
    private int workedHoursPerTask = 0;
    private boolean isDone;

    /*public Task(Responsible responsible) {
        this.hoursPerTask = new Random().nextInt(2) + 1;
        this.name = responsible.getNameOfResponsibility();
    }*/

    public Task(String name) {
        this.hoursPerTask = new Random().nextInt(2) + 1;
        this.name = name;
    }

    /*public Task(String name) {
        this.name = name;
    }*/

    public int getHoursPerTask() {
        return hoursPerTask;
    }

    public String getName() {
        return name;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrentTask(boolean current) {
        isCurrent = current;
    }

    public int getWorkedHoursPerTask() {
        return workedHoursPerTask;
    }

    public void incrementWorkedHoursPerTask() {
        workedHoursPerTask++;
    }

    public void setWorkedHoursPerTask(int workedHoursPerTask) {
        this.workedHoursPerTask = workedHoursPerTask;
    }

    public boolean isTaskExecuted() {
        if (hoursPerTask == workedHoursPerTask) {
            isCurrent = false;
            isDone = true;
            return true;
        }
        return false;
    }

    public boolean isTaskDone() {
        return isDone;
    }

    public boolean isMatchableWithResponsibility(Responsible responsibility) {
        if (getName().equalsIgnoreCase(responsibility.getNameOfResponsibility())) {
            return true;
        }
        else {
            return false;
        }
    }
}
