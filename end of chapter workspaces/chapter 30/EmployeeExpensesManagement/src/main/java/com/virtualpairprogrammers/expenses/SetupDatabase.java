package com.virtualpairprogrammers.expenses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SetupDatabase {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        try (Connection connection = DriverManager.getConnection("jdbc:h2:./expenses", "sa", "")) {
            Statement statement = connection.createStatement();
//            String sql = "CREATE TABLE employees (id INTEGER, title VARCHAR(255), firstName VARCHAR(255), " +
//                    "surname VARCHAR(255), jobTitle VARCHAR(255), department VARCHAR(255), " +
//                    "PRIMARY KEY (id))";
//            statement.executeUpdate(sql);

            String claimsSQL = "CREATE TABLE expenseclaims (id INTEGER, employeeId INTEGER, dateOfClaim VARCHAR(255), approved TINYINT, paid TINYINT, PRIMARY KEY (id) )";
            String expenseItemsSQL = "CREATE TABLE expenseitems (id INTEGER, claimId INTEGER, expenseType VARCHAR(255), description VARCHAR(255), amount DOUBLE, PRIMARY KEY (id) )";

            statement.executeUpdate(claimsSQL);
            statement.executeUpdate(expenseItemsSQL);

        }
    }
}
