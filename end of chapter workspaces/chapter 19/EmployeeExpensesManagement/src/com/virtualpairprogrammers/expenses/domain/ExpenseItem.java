package com.virtualpairprogrammers.expenses.domain;

import java.util.Objects;

public class ExpenseItem {

    private Integer id;
    private Integer claimId;
    private ExpenseType expenseType;
    private String description;
    private Double amount;

    public ExpenseItem(Integer id, Integer claimId, ExpenseType expenseType, String description, Double amount) {
        this.id = id;
        this.claimId = claimId;
        this.expenseType = expenseType;
        this.description = description;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public Integer getClaimId() {
        return claimId;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public String getDescription() {
        return description;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "ExpenseItem{" +
                "id=" + id +
                ", claimId=" + claimId +
                ", expenseType='" + expenseType + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseItem that = (ExpenseItem) o;
        return Objects.equals(id, that.id) && Objects.equals(claimId, that.claimId) && Objects.equals(expenseType, that.expenseType) && Objects.equals(description, that.description) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, claimId, expenseType, description, amount);
    }
}
