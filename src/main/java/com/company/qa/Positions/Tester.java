package com.company.qa.Positions;

public class Tester implements Position, Responsible {

    public Tester() {

    }

    public String getNameOfPosition() {
        return "Tester";
    }

    public int getSalaryRate() {
        return 7;
    }

    public String getNameOfResponsibility() {
        return "Test program";
    }
}
