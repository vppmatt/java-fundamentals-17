package com.virtualpairprogrammers.expenses.domain;

import com.virtualpairprogrammers.expenses.exceptions.EmployeeNotFoundException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeesDatabaseImpl implements Employees{

    public EmployeesDatabaseImpl() throws ClassNotFoundException {
        Class.forName("org.h2.Driver");
    }

    @Override
    public void addEmployee(Employee employee) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./expenses", "sa", "")) {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO employees (id, title, firstName, surname, jobTitle, department)" +
                    " VALUES (" + employee.getId() + ", '" + employee.getTitle() + "'," +
                    "'" + employee.getFirstName() + "', '" + employee.getSurname() + "'," +
                    "'" + employee.getJobTitle() + "', '" + employee.getDepartment() + "')";
            statement.executeUpdate(sql);

        } catch (SQLException throwables) {
            System.out.println("There was a problem connection to the database");
            throw new RuntimeException(throwables);
        }
    }

    private List<ExpenseItem> getExpenseItemsForClaim(int claimId) {
        List<ExpenseItem> itemsList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./expenses", "sa", "")) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM expenseitems WHERE claimId = " + claimId);
            while (rs.next()) {
                int id = rs.getInt("id");
                String expenseType = rs.getString("expenseType");
                String description = rs.getString("description");
                Double amount = rs.getDouble("amount");

                ExpenseItem ei = new ExpenseItem(id, claimId, ExpenseType.valueOf(expenseType.toUpperCase()),
                description, amount);
                itemsList.add(ei);

            }
        } catch (SQLException throwables) {
            System.out.println("There was a problem connection to the database");
            throw new RuntimeException(throwables);
        }

        return itemsList;
    }

    private List<ExpenseClaim> getExpenseClaimsForEmployee(int employeeId) {
        List<ExpenseClaim> claimsList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./expenses", "sa", "")) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM expenseclaims WHERE employeeId = " + employeeId);
            while (rs.next()) {
                int id = rs.getInt("id");
                String dateOfClaim = rs.getString("dateOfClaim");
                Boolean approved = rs.getBoolean("approved");
                Boolean paid = rs.getBoolean("paid");

                ExpenseClaim claim = new ExpenseClaim(id,employeeId, LocalDate.parse(dateOfClaim));
                claim.setApproved(approved);
                claim.setPaid(paid);
                List<ExpenseItem> expenseItems = getExpenseItemsForClaim(id);
                expenseItems.forEach( ei -> claim.addExpenseItem(ei));
                claimsList.add(claim);

            }
        } catch (SQLException throwables) {
            System.out.println("There was a problem connection to the database");
            throw new RuntimeException(throwables);
        }

        return claimsList;
    }

    @Override
    public List<Employee> getEmployeeList() {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./expenses", "sa", "")) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employees");
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String firstName = rs.getString("firstName");
                String surname = rs.getString("surname");
                String jobTitle = rs.getString("jobTitle");
                Department department = Department.valueOf(rs.getString("department").toUpperCase());

                Employee e = new Employee(id,title, firstName, surname, jobTitle, department);
                List<ExpenseClaim> claims = getExpenseClaimsForEmployee(id);
                claims.forEach( claim -> e.addClaim(claim));
                employeeList.add(e);

            }
        } catch (SQLException throwables) {
            System.out.println("There was a problem connection to the database");
            throw new RuntimeException(throwables);
        }

        return employeeList;
    }

    @Override
    public void printEmployees() {

        List<Employee> employeeList = getEmployeeList();

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

        try (Connection connection = DriverManager.getConnection("jdbc:h2:./expenses", "sa", "")) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employees WHERE surname like '%" + surname + "%'");
            if (!rs.next()) return null;

                int id = rs.getInt("id");
                String title = rs.getString("title");
                String firstName = rs.getString("firstName");

                String jobTitle = rs.getString("jobTitle");
                Department department = Department.valueOf(rs.getString("department").toUpperCase());

                Employee e = new Employee(id,title, firstName, surname, jobTitle, department);
                List<ExpenseClaim> claims = getExpenseClaimsForEmployee(id);
                claims.forEach( claim -> e.addClaim(claim));
                return e;


        } catch (SQLException throwables) {
            System.out.println("There was a problem connection to the database");
            throw new RuntimeException(throwables);
        }

    }

    @Override
    public Employee findById(int id) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./expenses", "sa", "")) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM employees WHERE id = " + id);
            if (!rs.next()) return null;


            String title = rs.getString("title");
            String firstName = rs.getString("firstName");
            String surname = rs.getString("surname");
            String jobTitle = rs.getString("jobTitle");
            Department department = Department.valueOf(rs.getString("department").toUpperCase());

            Employee e = new Employee(id,title, firstName, surname, jobTitle, department);
            List<ExpenseClaim> claims = getExpenseClaimsForEmployee(id);
            claims.forEach( claim -> e.addClaim(claim));
            return e;

        } catch (SQLException throwables) {
            System.out.println("There was a problem connection to the database");
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public boolean employeeExists(int id) {
        if (findById(id) == null) {
            return false;
        }
        return true;
    }

    private void addExpenseItem(ExpenseItem item) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./expenses", "sa", "")) {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO expenseitems (id, claimId, expenseType, description, amount) VALUES " +
                    " (" + item.getId() + ", " + item.getClaimId() + ", '" +
                    item.getExpenseType().toString() + "', '"+ item.getDescription() +
                    "', " + item.getAmount() + ")";
            statement.executeUpdate(sql);

        } catch (SQLException throwables) {
            System.out.println("There was a problem connection to the database");
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public void addExpenseClaim(ExpenseClaim claim) throws EmployeeNotFoundException {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./expenses", "sa", "")) {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO expenseclaims (id, employeeId, dateOfClaim, approved, paid) VALUES " +
                     " (" + claim.getId() + ", " + claim.getEmployeeId() + ", '" +
                    claim.getDateOfClaim().toString() + "', " + claim.getApproved() + ", " + claim.getPaid() + ")";
            statement.executeUpdate(sql);

            claim.getExpenseItems().forEach (ei -> addExpenseItem(ei));


        } catch (SQLException throwables) {
            System.out.println("There was a problem connection to the database");
            throw new RuntimeException(throwables);
        }
    }
}
