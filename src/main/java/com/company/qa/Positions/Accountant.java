package com.company.qa.Positions;

import com.company.qa.Employee;
import com.company.qa.Freelancer;

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
    }
}
