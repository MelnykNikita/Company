package com.company.qa.Positions;

public class Programmer implements Position, Responsible {

    public Programmer(){

    }

    public String getNameOfPosition(){
        return "Programmer";
    }

    public int getSalaryRate() {
        return 8;
    }

    public String getNameOfResponsibility() {
        return "Write code";
    }
}
