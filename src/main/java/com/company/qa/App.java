package com.company.qa;

import com.company.qa.Positions.Position;

public class App
{
    public static void main( String[] args )
    {
        Company company = new Company();
        System.out.println("Amount Of Employees: " + company.getAmountOfEmployees());
        for (Employee employee: company.getEmployeeList()) {
            System.out.print(employee + ":\t");
            for (Position position: employee.getPositionList()) {
                System.out.print(position.getName() + "\t");
            }
            System.out.println();
        }

    }
}
