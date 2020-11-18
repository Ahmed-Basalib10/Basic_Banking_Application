package com.bankingappsparks.model;

public class Accounts {
    public int id1;
    public String name;
    public String account_no;
    public String email;
    public String phone;
    public int balance;

    public Accounts() {
    }


    public Accounts(int id1, String name, String account_no, String email, String phone, int balance) {
        this.id1 = id1;
        this.name = name;
        this.account_no = account_no;
        this.email = email;
        this.phone = phone;
        this.balance = balance;
    }


    public int getId1() {
        return id1;
    }

    public String getName() {
        return name;
    }

    public String getAccount_no() {
        return account_no;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getBalance() {
        return balance;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount_no(String account_no) {
        this.account_no = account_no;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
