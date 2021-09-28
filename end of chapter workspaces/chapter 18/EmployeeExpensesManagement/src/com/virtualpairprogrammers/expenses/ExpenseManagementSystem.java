package com.virtualpairprogrammers.expenses;

import com.virtualpairprogrammers.expenses.domain.Employee;
import com.virtualpairprogrammers.expenses.domain.Employees;
import com.virtualpairprogrammers.expenses.domain.ExpenseClaim;
import com.virtualpairprogrammers.expenses.exceptions.EmployeeNotFoundException;
import com.virtualpairprogrammers.expenses.ui.UIFunctions;

import java.util.Scanner;

public class ExpenseManagementSystem {

    public static void main(String[] args) {
        Employees employees = new Employees(10);
        Scanner scanner = new Scanner(System.in);
        UIFunctions uiFunctions = new UIFunctions();

        boolean readyToExit = false;

        while(!readyToExit) {

            System.out.println("Expense Management System");
            System.out.println("-------------------------");
            System.out.println("e - register new employee");
            System.out.println("c - register new claim");
            System.out.println("p - print all employees");
            System.out.println("x - exit");

            String option = scanner.nextLine();

            switch (option) {
                case "e":
                    Employee e = uiFunctions.registerNewEmployee();
                    employees.addEmployee(e);
                    break;
                case "c":
                    ExpenseClaim claim = uiFunctions.registerNewExpenseClaim();
                    try {
                        employees.addExpenseClaim(claim);
                    } catch (EmployeeNotFoundException employeeNotFoundException) {
                        System.out.println("There was no employee with ID " + claim.getEmployeeId());
                    }
                    break;
                case "p":
                    employees.printEmployees();
                    break;
                case "x": //exit
                    readyToExit = true;
                    break;
                default:
                    System.out.println("Option not valid");
            }
        }

    }
}
