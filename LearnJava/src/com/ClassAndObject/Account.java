package com.ClassAndObject;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;

    private Client client;
    private ArrayList<Transaction> transactions;

    public Account(int id, double balance, double annualInterestRate, Client client) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.client = client;

        this.transactions = new ArrayList<>();
        this.dateCreated = new Date();
    }

    public boolean withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Not enough balance");
            return false;
        } else {
            balance -= amount;
            transactions.add(new Transaction('W', amount, balance, "withdraw: " + amount));
        }
        return true;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction('D', amount, balance, "deposit: " + amount));
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public int countTransaction (char type) {
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getType() == type) {
                count ++;
            }
        }
        return count;
    }

    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public String toString() {
        return "Account ID: " + id + ", Balance: " + balance + ", Annual Interest Rate: " + annualInterestRate + ", Created Date: " + dateCreated + "\n" + transactions + "\n";
    }
}
