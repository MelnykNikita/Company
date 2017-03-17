package com.company.qa;

import com.company.qa.Positions.*;
import com.company.qa.Task.Task;

import java.util.ArrayList;
import java.util.List;

public class Freelancer {

    private List<Task> taskList = new ArrayList<Task>();
    private int workedHours = 0;
    private int index = 0;

    /*private Programmer programmer;
    private Designer designer;
    private Tester tester;
    private Manager manager;
    private Accountant accountant;*/
    private Responsible responsibility;
    private Position position;

    Freelancer(Programmer programmer) {
        responsibility = programmer;
        position = programmer;
    }

    Freelancer(Designer designer) {
        responsibility = designer;
        position = designer;
    }

    Freelancer(Tester tester) {
        responsibility = tester;
        position = tester;
    }

    Freelancer(Manager manager) {
        responsibility = manager;
        position = manager;
    }

    Freelancer(Accountant accountant) {
        responsibility = accountant;
        position = accountant;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public int getWorkedHours() {
        return workedHours;
    }
}
