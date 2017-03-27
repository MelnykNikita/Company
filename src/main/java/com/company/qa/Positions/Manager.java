package com.company.qa.Positions;

public class Manager implements Position, Responsible {

    public Manager() {

    }

    public String getNameOfPosition() {
        return "Manager";
    }

    public int getSalaryRate() {
        return 2400;
    }

    public String getNameOfResponsibility() {
        return "Sell services";
    }
}
