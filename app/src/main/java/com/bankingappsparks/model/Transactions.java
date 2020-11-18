package com.bankingappsparks.model;

public class Transactions {
    public int id;
    public String date;
    public String time;
    public String sender_acc;
    public String rec_acc;
    public int amount;
    public String ststus;
    public int userkey;

    public Transactions(int id, String date, String time, String sender_acc, String rec_acc, int amount, String ststus, int userkey) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.sender_acc = sender_acc;
        this.rec_acc = rec_acc;
        this.amount = amount;
        this.ststus = ststus;
        this.userkey = userkey;
    }

    public Transactions() {
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getSender_acc() {
        return sender_acc;
    }

    public String getRec_acc() {
        return rec_acc;
    }

    public int getAmount() {
        return amount;
    }

    public String getStstus() {
        return ststus;
    }

    public int getUserkey() {
        return userkey;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setSender_acc(String sender_acc) {
        this.sender_acc = sender_acc;
    }

    public void setRec_acc(String rec_acc) {
        this.rec_acc = rec_acc;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setStstus(String ststus) {
        this.ststus = ststus;
    }

    public void setUserkey(int userkey) {
        this.userkey = userkey;
    }
}
