package com.virtualpairprogrammers.expenses.utilities;

import com.virtualpairprogrammers.expenses.domain.Employee;
import com.virtualpairprogrammers.expenses.domain.EmployeesInMemoryImpl;
import com.virtualpairprogrammers.expenses.exceptions.InvalidEmployeeIdException;
import com.virtualpairprogrammers.expenses.exceptions.NameTooShortException;

public class EmployeeUtilities {

    public boolean employeeExists(EmployeesInMemoryImpl employees, Employee employee) {
        return employees.findBySurname(employee.getSurname()) != null;
    }

    public Integer validateEmployeeId(String inputId) throws InvalidEmployeeIdException {
        try {
            Integer id = Integer.valueOf(inputId);
            return id;
        }
        catch (NumberFormatException e) {
            throw new InvalidEmployeeIdException();
        }
    }

    public void validateEmployeeName(String firstName, String surname) throws NameTooShortException {
        Integer length = firstName.length() + surname.length();
        if (length < 6) {
            throw new NameTooShortException();
        }
    }

}
