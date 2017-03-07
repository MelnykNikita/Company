package com.company.qa.Positions;

public class Accountant implements Position, Responsible {

    public String getNameOfPosition() {
        return "Accountant";
    }

    public int getSalaryRate() {
        return 1200;
    }

    public String getNameOfResponsibility() {
        return "Create report";
    }
}
