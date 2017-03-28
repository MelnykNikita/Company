package com.company.qa;

public class App
{
    public static void main( String[] args ) throws InterruptedException {

        Company company = new Company();
        for (int week = 1; week < 5; week++) {
            for (int i = 0; i < 40; i++) {
                company.chiefGivesTasksForEmployees();
                company.setCurrentTasksForEmployees();
                company.incrementWorkedHours();
            }
            company.payWeekSalary();
        }
        company.accountantMakesMonthlyReport();
    }
}
