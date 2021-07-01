package com.example.milestone1.model;

public class WalletModel {

    private String userId;
    private String balance;

    public WalletModel(){}

    public WalletModel(String userId, String balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getUserId() {
        return userId;
    }

    public String getBalance() {
        return balance;
    }
}
