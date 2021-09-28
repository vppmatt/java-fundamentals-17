package com.virtualpairprogrammers.expenses;

import com.virtualpairprogrammers.expenses.domain.Department;
import com.virtualpairprogrammers.expenses.domain.Employee;

import java.util.Scanner;

public class RegisterNewEmployee {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();
        System.out.println("Enter the title");
        String title = scanner.nextLine();
        employee.setTitle(title);

        System.out.println("Enter the first name");
        String firstName = scanner.nextLine();
        employee.setFirstName(firstName);

        System.out.println("Enter the surname");
        String surname = scanner.nextLine();
        employee.setSurname(surname);

        System.out.println("Enter the department");
        String department = scanner.nextLine();
        Department d = Department.valueOf(department.toUpperCase());

        employee.setDepartment(d);

        System.out.println(employee);

    }
}
