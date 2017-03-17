package com.company.qa.Positions;

public class Designer implements Position, Responsible, IT {

    public Designer(){

    }

    public String getNameOfPosition() {
        return "Designer";
    }

    public int getSalaryRate() {
        return 6;
    }

    public String getNameOfResponsibility() {
        return "Draw layout";
    }
}
