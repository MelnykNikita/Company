package com.company.qa;

import com.company.qa.Positions.Position;
import com.company.qa.Task.Task;

public class App
{
    public static void main( String[] args )
    {
        Company company = new Company();
        for (int i = 1; i <= 2; i++) {
            company.chiefGivesTasksForEmployees();
            company.setCurrentTasksForEmployees();
            company.setWorkHours();
        }



        System.out.println("Amount Of Employees: " + company.getAmountOfEmployees());
        for (Employee employee: company.getEmployeeList()) {
            System.out.print(employee + ":\t" + employee.getWorkHoursPerWeek() + "\t" + employee.getWorkedHours());
            for (Position position: employee.getPositionList()) {
                System.out.print(position.getNameOfPosition() + "\t");
            }
            System.out.println();
            for (Task task: employee.getTaskList()) {
                System.out.println(task.getHoursPerTask()
                        + " hrs" + "\t" + task.getName() + "\t" + task.getStatusOfTask());
            }
            System.out.println();
        }



    }
}
