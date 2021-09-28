package com.virtualpairprogrammers.expenses;

import com.virtualpairprogrammers.expenses.domain.*;

public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setTitle("Mr");
        employee1.setFirstName("Matt");
        employee1.setSurname("Greencroft");

        System.out.println(employee1.getMailingName());
        System.out.println(employee1.getMailingName(true));
        System.out.println(employee1.getMailingName(false));

        Employee employee2 = new Employee(2, "Manager");
        employee2.setTitle("Dr");
        employee2.setFirstName("Denis");
        employee2.setSurname("Yellow");

        Employees employees = new Employees(15);
        employees.addEmployee(employee1);
        employees.addEmployee(employee2);
        employees.addEmployee( new Employee(3, "Mrs", "Susan", "Brown", "Director", Department.MARKETING)  );

        employees.printEmployees();

        Employee foundEmployee = employees.findBySurname("Brown");
        System.out.println("Found " + foundEmployee.getMailingName());

        Employee foundEmployee2 = employees.findBySurname("Cyan");
        System.out.println("Didn't find " + (foundEmployee2 == null));


        ExpenseClaim expenseClaim = new ExpenseClaim(24,642,"2021-09-01",26.99);
        System.out.println(expenseClaim.getEmployeeId());
        expenseClaim.setPaid(true);
        System.out.println(expenseClaim.getPaid());
        expenseClaim.setApproved(true);
        expenseClaim.setPaid(true);
        System.out.println(expenseClaim.getPaid());

        ExpenseItem expenseItem = new ExpenseItem(24, 102, ExpenseType.ACCOMODATION, "The Grand Hotel", 69.99);
        System.out.println(expenseItem.getDescription());

        System.out.println(employee1);

        String name1 = "Matt";
        String name2 = "Matt";

        Employee employee3 = new Employee();
        employee3.setId(1);
        employee3.setTitle("Mr");
        employee3.setFirstName("Matt");
        employee3.setSurname("Greencroft");

        System.out.println(employee1.equals(employee3));
        System.out.println(employee1 == employee1);
        System.out.println(employee1.getClass());

    }
}
