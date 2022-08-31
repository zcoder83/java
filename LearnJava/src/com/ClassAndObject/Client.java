package com.ClassAndObject;

import java.util.ArrayList;

public class Client {
    private int id;
    private String name;
    private String phone;
    private ArrayList<Account> accounts;

    public Client(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        // initiate accounts
        accounts = new ArrayList<>();
    }
    public boolean addAccount(Account account) {
        if(account != null) {
            accounts.add(account );
            return true;
        }
        System.out.println("Not valid account!");
        return false;
    }
    public boolean removeAccount(int accountID) {
        for (Account account : accounts) {
            if (account.getId() == accountID) {
                accounts.remove(account);
                return true;
            }
        }
        return false;
    }
    public String toString() {
        String allInfo;
        allInfo = "Client ID: " + id + ", Name: " + name + ", Phone: " + phone + "\n";
        for (Account account : accounts) {
            allInfo += account + "\n";
        }
        return allInfo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
