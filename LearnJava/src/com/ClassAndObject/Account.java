package com.ClassAndObject;

import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    public Account (int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = new Date();
    }

    public boolean withdraw (double amount) {
        if (balance < amount) {
            System.out.println("Not enough balance");
            return false;
        } else {
            this.balance -= amount;
        }
        return true;
    }

    public void deposit (double amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public double getBalance() {
        return this.balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getAnnualInterestRate(){
        return this.annualInterestRate;
    }
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    public Date getDateCreated() {
        return this.dateCreated;
    }
    public String displayAccount () {
        return "\nID: " + id + ", Balance: " + balance + ", Annual Interest Rate: " + annualInterestRate + ", Created Date: " + dateCreated;
    }
}
