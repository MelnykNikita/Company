package com.company.qa.Positions;

import com.company.qa.Employee;
import com.company.qa.Freelancer;
import com.company.qa.Task.Task;

import java.io.*;
import java.util.List;

public class Accountant implements Position, Responsible {

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
        File file = new File("D:\\MVN\\qa\\src\\main\\java\\data\\MonthlyReport.txt");
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        PrintWriter printWriter = null;

        try {
            fileWriter = new FileWriter(file, false);
            bufferedWriter = new BufferedWriter(fileWriter);
            printWriter = new PrintWriter(bufferedWriter, false);

            printWriter.println("Amount Of Employees: " + employeeList.size());

            for (Employee employee: employeeList) {
                printWriter.print(employee + ":  " + employee.getMaxWorkHoursPerMonth() + " MAX hrs/month \t"
                        + employee.getMaxWorkHoursPerWeek() + " MAX hrs/week \t"
                        + employee.getWorkedHours() + " ACTUAL hrs/work \t"
                        + employee.getWorkedHoursIT() + " hrs/IT \t"
                        + employee.getWorkedHoursAsProgrammer() + " hrs/prog \t"
                        + employee.getWorkedHoursAsDesigner() + " hrs/des \t"
                        + employee.getWorkedHoursAsTester() + " hrs/test \t"
                        + employee.getSalary() + " $\t");
                for (Position position : employee.getPositionList()) {
                    printWriter.println(position.getNameOfPosition() + "\t");
                }
                /*System.out.println();
                for (Task task: employee.getTaskList()) {
                    System.out.println(task.getHoursPerTask()
                            + " hrs" + "\t" + task.getName() + "\t"
                            + task.isCurrent() + "\t" + task.getWorkedHoursPerTask());
                }
                System.out.println("---------------------------------------------------------");
            }

            System.out.println("Freelancers....................................................");
            System.out.println("Amount Of Freelancers: " + freelancerList.size());

            for (Freelancer freelancer: freelancerList) {
                System.out.println(freelancer + ":  " + freelancer.getWorkHoursPerMonth() + " hrs/month \t"
                        + freelancer.getMaxWorkHoursPerWeek() + " hrs/week \t"
                        + freelancer.getWorkedHours() + " hrs/work \t"
                        + freelancer.getSalary() + " $\t");
                for (Position position: freelancer.getPositions()) {
                    System.out.println(position.getNameOfPosition() + "\t");
                }
                System.out.println();
                for (Task task: freelancer.getTaskList()) {
                    System.out.println(task.getHoursPerTask()
                            + " hrs" + "\t" + task.getName() + "\t"
                            + task.isCurrent() + "\t" + task.getWorkedHoursPerTask());
                }
                System.out.println("---------------------------------------------------------");*/

            }
        }
        catch (IOException e) {
            System.err.println(e.getMessage());
        }
        finally {
            printWriter.close();
        }


    }
}
