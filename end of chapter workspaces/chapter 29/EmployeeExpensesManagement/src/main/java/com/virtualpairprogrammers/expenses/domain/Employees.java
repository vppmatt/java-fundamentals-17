package com.virtualpairprogrammers.expenses.domain;

import com.virtualpairprogrammers.expenses.exceptions.EmployeeNotFoundException;

import java.util.List;

public interface Employees {
    void addEmployee(Employee employee);

    List<Employee> getEmployeeList();

    void printEmployees();

    Employee findBySurname(String surname);

    Employee findById(int id);

    boolean employeeExists(int id);

    void addExpenseClaim(ExpenseClaim claim) throws EmployeeNotFoundException;
}
