package com.virtualpairprogrammers.expenses;

import com.virtualpairprogrammers.expenses.domain.*;
import com.virtualpairprogrammers.expenses.exceptions.EmployeeNotFoundException;
import com.virtualpairprogrammers.expenses.management.ExpenseManagementProcess;
import com.virtualpairprogrammers.expenses.management.ExpressExpenseManagementProcess;
import com.virtualpairprogrammers.expenses.management.RegularExpenseManagementProcess;
import com.virtualpairprogrammers.expenses.ui.UIFunctions;
import com.virtualpairprogrammers.expenses.utilities.ExpenseAnalysis;
import com.virtualpairprogrammers.expenses.utilities.ExpenseAnalysisImpl;
import com.virtualpairprogrammers.expenses.utilities.ExpenseAnalysisTempImpl;

import java.time.LocalDate;
import java.util.Scanner;

public class ExpenseManagementSystem {

    public static void main(String[] args) throws ClassNotFoundException {
        Employees employees = new EmployeesDatabaseImpl();
        Scanner scanner = new Scanner(System.in);
        UIFunctions uiFunctions = new UIFunctions();

        ExpenseManagementProcess expressEMP = new ExpressExpenseManagementProcess();
        ExpenseManagementProcess regularEMP = new RegularExpenseManagementProcess();

        boolean readyToExit = false;

        while(!readyToExit) {

            System.out.println("Expense Management System");
            System.out.println("-------------------------");
            System.out.println("e - register new employee");
            System.out.println("c - register new claim");
            System.out.println("p - print all employees");
            System.out.println("a - approve claim");
            System.out.println("r1 - outstanding expense claims");
            System.out.println("r2 - paid expense claims");
            System.out.println("r3 - expense claims above specified amount");
            System.out.println("x - exit");

            String option = scanner.nextLine();

            ExpenseAnalysis expenseAnalysis = new ExpenseAnalysisImpl(employees);

            switch (option) {
                case "e":
                    Employee e = uiFunctions.registerNewEmployee();
                    employees.addEmployee(e);
                    break;
                case "c":
                    ExpenseClaim claim = uiFunctions.registerNewExpenseClaim();
                    try {
                        employees.addExpenseClaim(claim);
                        expressEMP.registerExpenseClaim(claim);
                        int id = regularEMP.registerExpenseClaim(claim);
                        System.out.println("The claim has been registered with ID " + id);
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
                case "a" :
                    System.out.println("Enter the claim Id");
                    int claimId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Enter the employee Id");
                    int employeeId = scanner.nextInt();
                    scanner.nextLine();

                    Employee foundEmployee = employees.findById(employeeId);

                    System.out.println("Enter r for regular, or e for express");
                    String claimType = scanner.nextLine();

                    ExpenseManagementProcess requestedProcess;
                    if (claimType.equals("r")) {
                        requestedProcess = regularEMP;
                    }
                    else {
                        requestedProcess = expressEMP;
                    }
                    boolean result = requestedProcess.approveClaim(claimId, foundEmployee);
                    System.out.println("The result was " + result);

                    break;
                case "r1":
                    expenseAnalysis.printOutstandingClaims();
                    break;
                case "r2":
                    System.out.println("Enter date from ");
                    String dateFrom = scanner.nextLine();

                    System.out.println("Enter date to ");
                    String dateTo = scanner.nextLine();

                    expenseAnalysis.printPaidClaims(LocalDate.parse(dateFrom), LocalDate.parse(dateTo));
                    break;
                case "r3":
                    System.out.println("Enter amount ");
                    Double amount = scanner.nextDouble();
                    scanner.nextLine();

                    expenseAnalysis.printClaimsOverAmount(amount);
                    break;
                default:
                    System.out.println("Option not valid");
            }
        }

    }
}
