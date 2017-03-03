package com.company.qa;

import com.company.qa.Positions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Employee {

    private int amountOfPositions;
    private List<Position> positionList; // transform to SET !!! Hashset

    Employee(){
        this.amountOfPositions = new Random().nextInt(2) + 1;
        positionList = new ArrayList<Position>();
        for (int i = 1; i <= amountOfPositions; i++){
            positionList.add(getSelectedPosition());
        }
    }

    public Position getSelectedPosition(){
        int numberForPosition = new Random().nextInt(4) + 1;
        switch (numberForPosition){
            case 1: return new Programmer();
            case 2: return new Designer();
            case 3: return new Tester();
            case 4: return new Manager();
            default: return null;
        }
    }

    public List<Position> getPositionList(){
        return positionList;
    }
}
