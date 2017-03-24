package com.company.qa;

import com.company.qa.Positions.Position;
import com.company.qa.Task.Task;

public class App
{
    public static void main( String[] args ) throws InterruptedException {

        Company company = new Company();
        for (int week = 1; week < 5; week++) {
            for (int i = 1; i < 41; i++) {
                company.chiefGivesTasksForEmployees();
                company.setCurrentTasksForEmployees();
                company.incrementWorkedHours();
            }
        }




        System.out.println("Amount Of Employees: " + company.getAmountOfEmployees());

        for (Employee employee: company.getEmployeeList()) {
            System.out.print(employee + ":  " + employee.getWorkHoursPerMonth() + " hrs/month \t"
                    + employee.getWorkHoursPerWeek() + " hrs/week \t"
                    + employee.getWorkedHours() + " hrs/work \t"
                    + employee.getWorkedHoursIT() + " hrs/IT \t"
                    + employee.getWorkedHoursAsProgrammer() + " hrs/programmer \t"
                    + employee.getWorkedHoursAsDesigner() + " hrs/designer \t"
                    + employee.getWorkedHoursAsTester() + " hrs/tester \t");
            for (Position position: employee.getPositionList()) {
                System.out.print(position.getNameOfPosition() + "\t");
            }
            System.out.println();
            for (Task task: employee.getTaskList()) {
                System.out.println(task.getHoursPerTask()
                        + " hrs" + "\t" + task.getName() + "\t"
                        + task.isCurrent() + "\t" + task.getWorkedHoursPerTask());
            }
            System.out.println("---------------------------------------------------------");
        }

        System.out.println("Freelancers....................................................");
        System.out.println("Amount Of Freelancers: " + company.getFreelancerList().size());

        for (Freelancer freelancer: company.getFreelancerList()) {
            System.out.println(freelancer + ":  " + freelancer.getWorkHoursPerMonth() + " hrs/month \t"
                    + freelancer.getWorkHoursPerWeek() + " hrs/week \t"
                    + freelancer.getWorkedHours() + " hrs/work \t");
            for (Position position: freelancer.getPositions()) {
                System.out.println(position.getNameOfPosition() + "\t");
            }
            System.out.println();
            for (Task task: freelancer.getTaskList()) {
                System.out.println(task.getHoursPerTask()
                        + " hrs" + "\t" + task.getName() + "\t"
                        + task.isCurrent() + "\t" + task.getWorkedHoursPerTask());
            }
            System.out.println("---------------------------------------------------------");
        }




    }
}
