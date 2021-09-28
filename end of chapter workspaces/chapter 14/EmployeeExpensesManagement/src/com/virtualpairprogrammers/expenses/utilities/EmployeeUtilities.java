package com.virtualpairprogrammers.expenses.utilities;

import com.virtualpairprogrammers.expenses.domain.Employee;
import com.virtualpairprogrammers.expenses.domain.Employees;

public class EmployeeUtilities {

    public boolean employeeExists(Employees employees, Employee employee) {
        return employees.findBySurname(employee.getSurname()) != null;
    }

}
