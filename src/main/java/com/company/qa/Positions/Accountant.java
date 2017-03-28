package com.company.qa.Positions;

import com.company.qa.Employee;
import com.company.qa.Freelancer;

import java.io.*;
import java.util.List;

public class Accountant implements Position, Responsible {

    private int totalSalary = 0;
    private int totalWorkHours = 0;

    public String getNameOfPosition() {
        return "Accountant";
    }

    public int getSalaryRate() {
        return 1200;
    }

    public String getNameOfResponsibility() {
        return "Create report";
    }

    public void payWeekSalary(List<Employee> employeeList, List<Freelancer> freelancerList) {
        for (Employee employee: employeeList) {
            employee.setWeekSalary();
        }

        for (Freelancer freelancer: freelancerList) {
            freelancer.setWeekSalary();
        }
    }

    public void makeMonthlyReport(List<Employee> employeeList, List<Freelancer> freelancerList) throws IOException {

        File file = new File("\\MonthlyReport.txt");
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter(file, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter, false);

            printWriter.println("\t\t\tAccounting Report\n");
            printWriter.println("Employees: " + employeeList.size());
            printWriter.println("Freelancers: " + freelancerList.size());

            printWriter.println("\n\t\t\tEMPLOYEES\n");
            printWriter.println("Employee\t\tPosition\t     Actual worked hours       Salary\t\t\n" );

            for (Employee employee: employeeList) {
                totalWorkHours += employee.getWorkedHours();
                totalSalary += employee.getSalary();

                printWriter.print(employee.toString() + ":\t\t");

                printWriter.print(String.format("%-20s %-25s %-25s",
                        employee.positionToString(), employee.getWorkedHours() + " hrs",
                        employee.getSalary() + " $"));
                printWriter.println();
            }

            printWriter.println("\n\t\t\tFREELANCERS\n");
            printWriter.println("Freelancer\t\tPosition\t\t\tActual worked hours\t\t   Salary\t\t\n" );

            for (Freelancer freelancer: freelancerList) {
                totalWorkHours += freelancer.getWorkedHours();
                totalSalary += freelancer.getSalary();

                printWriter.print(freelancer.toString() + ":\t\t");

                printWriter.print(String.format("%-20s %-25s %-25s",
                        freelancer.positionToString(), freelancer.getWorkedHours() + " hrs",
                        freelancer.getSalary() + " $"));
                printWriter.println();
            }
            
            printWriter.print("\nTOTAL\t\t\t\t\t           " + totalWorkHours
                    + " hrs\t                 " + totalSalary + " $");
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        finally {
            printWriter.close();
        }


    }
}
