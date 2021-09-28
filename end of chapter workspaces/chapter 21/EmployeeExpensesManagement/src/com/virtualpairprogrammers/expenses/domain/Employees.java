package com.virtualpairprogrammers.expenses.domain;

import com.virtualpairprogrammers.expenses.exceptions.EmployeeNotFoundException;
import com.virtualpairprogrammers.expenses.ui.UIFunctions;

import java.util.HashSet;

public class Employees {

    private HashSet<Employee> employees = new HashSet<>();

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void printEmployees() {
        for(Employee e : employees) {
                System.out.println(e);
        }
    }

    public Employee findBySurname(String surname) {
        for(Employee e : employees) {
            if (e.getSurname().equals(surname)) {
                return e;
            }
        }
        return null;
    }

    public Employee findById(int id) {
        for(Employee e : employees) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null;
    }

    public boolean employeeExists(int id) {
        for(Employee e : employees) {
            if (e.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void addExpenseClaim(ExpenseClaim claim) throws EmployeeNotFoundException {
        int employeeId = claim.getEmployeeId();

        if (!employeeExists(employeeId)) {
            throw new EmployeeNotFoundException();
        }


        for(Employee e : employees) {
            if (e.getId() == employeeId) {
                e.getClaims().add(claim);
            }
        }
    }

}
