package com.company.qa;

import com.company.qa.Positions.Position;
import com.company.qa.Task.Task;

public class App
{
    public static void main( String[] args ) throws InterruptedException {
        Company company = new Company();
        for (int i = 1; i < 9; i++) {
            System.out.println(i + "\t");
            company.chiefGivesTasksForEmployees();
            company.setCurrentTasksForEmployees();
            company.incrementWorkedHours();
        }



        System.out.println("Amount Of Employees: " + company.getAmountOfEmployees());
        for (Employee employee: company.getEmployeeList()) {
            System.out.print(employee + ":  " + employee.getWorkHoursPerWeek()
                    + " hrs/week \t" + employee.getWorkedHours() + " hrs/work \t"
                    + employee.getWorkedHoursIT() + " hrs/IT \t");
            for (Position position: employee.getPositionList()) {
                System.out.print(position.getNameOfPosition() + "\t");
            }
            System.out.println();
            for (Task task: employee.getTaskList()) {
                System.out.println(task.getHoursPerTask()
                        + " hrs" + "\t" + task.getName() + "\t"
                        + task.isTaskCurrent() + "\t" + task.getWorkedHoursPerTask());
            }
            System.out.println();
        }



    }
}
