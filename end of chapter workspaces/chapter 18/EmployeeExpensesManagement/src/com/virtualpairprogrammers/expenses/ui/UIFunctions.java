package com.virtualpairprogrammers.expenses.ui;

import com.virtualpairprogrammers.expenses.domain.Department;
import com.virtualpairprogrammers.expenses.domain.Employee;
import com.virtualpairprogrammers.expenses.domain.ExpenseClaim;
import com.virtualpairprogrammers.expenses.exceptions.InvalidEmployeeIdException;
import com.virtualpairprogrammers.expenses.exceptions.NameTooShortException;
import com.virtualpairprogrammers.expenses.utilities.EmployeeUtilities;

import java.time.LocalDate;
import java.util.Scanner;

public class UIFunctions {

    public Employee registerNewEmployee() {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        EmployeeUtilities employeeUtilities = new EmployeeUtilities();

        boolean idIsValid = false;
        while(!idIsValid) {
            System.out.println("Enter the id");
            String inputId = scanner.nextLine();
            try {
                Integer id = employeeUtilities.validateEmployeeId(inputId);
                employee.setId(id);
                idIsValid = true;
            } catch (InvalidEmployeeIdException e) {
                System.out.println("The id you entered was invalid - try again.");
            }
        }

        System.out.println("Enter the title");
        String title = scanner.nextLine();
        employee.setTitle(title);

        boolean nameIsValid = false;
        while (!nameIsValid) {
            System.out.println("Enter the first name");
            String firstName = scanner.nextLine();
            employee.setFirstName(firstName);

            System.out.println("Enter the surname");
            String surname = scanner.nextLine();
            employee.setSurname(surname);

            try {
                employeeUtilities.validateEmployeeName(firstName, surname);
                nameIsValid = true;
            } catch (NameTooShortException e) {
                System.out.println("The name you entered was not valid - try again.");
            }
        }

        System.out.println("Enter the job title");
        String jobTitle = scanner.nextLine();
        employee.setJobTitle(jobTitle);

        boolean departmentIsValid = false;

        while(!departmentIsValid) {

            System.out.println("Enter the department");
            String department = scanner.nextLine();
            try {
                Department d = Department.valueOf(department.toUpperCase());
                employee.setDepartment(d);
                departmentIsValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("The department you entered was not valid - try again.");
            }
        }

        return(employee);
    }

    public ExpenseClaim registerNewExpenseClaim() {
        Scanner scanner = new Scanner(System.in);
        EmployeeUtilities employeeUtilities = new EmployeeUtilities();

        System.out.println("Enter the claim Id");
        int claimId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the employee Id");
        int employeeId = scanner.nextInt();
        scanner.nextLine();

        LocalDate dateOfClaim = LocalDate.now();

        System.out.println("Enter the amount");
        double totalAmount  = scanner.nextDouble();
        scanner.nextLine();

        ExpenseClaim claim = new ExpenseClaim(claimId, employeeId, dateOfClaim, totalAmount);
        return claim;

    }
}
