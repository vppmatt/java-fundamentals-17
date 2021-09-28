package com.virtualpairprogrammers.expenses.management;

import com.virtualpairprogrammers.expenses.domain.Employee;
import com.virtualpairprogrammers.expenses.domain.ExpenseClaim;

public interface ExpenseManagementProcess {

    public int registerExpenseClaim(ExpenseClaim claim);
    public boolean approveClaim(int id, Employee employee);
}
