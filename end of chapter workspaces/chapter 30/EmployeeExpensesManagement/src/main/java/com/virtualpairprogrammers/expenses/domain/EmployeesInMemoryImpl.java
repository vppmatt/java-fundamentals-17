package com.virtualpairprogrammers.expenses.domain;

import com.virtualpairprogrammers.expenses.exceptions.EmployeeNotFoundException;
import com.virtualpairprogrammers.expenses.ui.UIFunctions;

import java.util.*;

public class EmployeesInMemoryImpl implements Employees {

    private Map<Integer, Employee> employees = new HashMap<>();

    @Override
    public void addEmployee(Employee employee) {
        employees.put(employee.getId() , employee);
    }

    @Override
    public List<Employee> getEmployeeList() {
        return new ArrayList<Employee>(employees.values());
    }

    @Override
    public void printEmployees() {
        List<Employee> employeeList = new ArrayList<>(employees.values());
        Collections.sort(employeeList);
        for(Employee e : employeeList) {
                System.out.println(e);
                for (ExpenseClaim claim : e.getClaims().values()) {
                    System.out.println(claim);
                    claim.printExpenseItems();
                    System.out.println("Total value of claim " + claim.getTotalAmount());
                }
        }
    }

    @Override
    public Employee findBySurname(String surname) {
        for(Employee e : employees.values()) {
            if (e.getSurname().equals(surname)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public Employee findById(int id) {
        return employees.get(id);
    }

    @Override
    public boolean employeeExists(int id) {
        return employees.containsKey(id);
    }

    @Override
    public void addExpenseClaim(ExpenseClaim claim) throws EmployeeNotFoundException {
        int employeeId = claim.getEmployeeId();

        if (!employeeExists(employeeId)) {
            throw new EmployeeNotFoundException();
        }


        for(Employee e : employees.values()) {
            if (e.getId() == employeeId) {
                e.getClaims().put(claim.getId(), claim);
            }
        }
    }

}
