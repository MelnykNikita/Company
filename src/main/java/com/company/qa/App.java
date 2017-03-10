package com.company.qa;

import com.company.qa.Positions.Position;
import com.company.qa.Task.Task;

public class App
{
    public static void main( String[] args )
    {
        Company company = new Company();

        System.out.println("Amount Of Employees: " + company.getAmountOfEmployees());
        for (Employee employee: company.getEmployeeList()) {
            System.out.print(employee + ":\t" + employee.getWorkHoursPerWeek() + "\t");
            for (Position position: employee.getPositionList()) {
                System.out.print(position.getNameOfPosition() + "\t");
            }
            System.out.println();
            for (Task task: employee.getTaskList()) {
                System.out.println(task.getHoursPerTask() + " hrs" + "\t" + task.getName());
            }
            System.out.println();
        }

        //company.setCurrentTasksForEmployees();
        for (Employee employee: company.getEmployeeList()) {
            System.out.println(employee.getTaskList().size());
        }

    }
}
