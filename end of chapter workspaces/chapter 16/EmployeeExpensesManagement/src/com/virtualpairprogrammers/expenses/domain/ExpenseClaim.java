package com.virtualpairprogrammers.expenses.domain;

import java.util.Objects;

public class ExpenseClaim {

    private Integer id;
    private Integer employeeId;
    private String dateOfClaim;
    private Double totalAmount;
    private Boolean approved;
    private Boolean paid;

    public ExpenseClaim(Integer id, Integer employeeId, String dateOfClaim, Double totalAmount) {
        this.id = id;
        this.employeeId = employeeId;
        this.dateOfClaim = dateOfClaim;
        this.totalAmount = totalAmount;
        this.approved = false;
        this.paid = false;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public void setPaid(Boolean paid) {
        if (paid && !approved) {
            System.out.println("This item cannot be paid as it has not yet been approved");
        }
        else {
            this.paid = paid;
        }
    }

    public Integer getId() {
        return id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getDateOfClaim() {
        return dateOfClaim;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Boolean getApproved() {
        return approved;
    }

    public Boolean getPaid() {
        return paid;
    }

    @Override
    public String toString() {
        return "ExpenseClaim{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", dateOfClaim='" + dateOfClaim + '\'' +
                ", totalAmount=" + totalAmount +
                ", approved=" + approved +
                ", paid=" + paid +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseClaim that = (ExpenseClaim) o;
        return Objects.equals(id, that.id) && Objects.equals(employeeId, that.employeeId) && Objects.equals(dateOfClaim, that.dateOfClaim) && Objects.equals(totalAmount, that.totalAmount) && Objects.equals(approved, that.approved) && Objects.equals(paid, that.paid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employeeId, dateOfClaim, totalAmount, approved, paid);
    }
}
