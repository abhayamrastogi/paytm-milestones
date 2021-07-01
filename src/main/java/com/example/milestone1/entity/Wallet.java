package com.example.milestone1.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wallet")
public class Wallet {

    @Id
    @Column(name = "id")
    private Long walletID;

    @Column(name = "balance")
    private String balance;

    @Column(name = "userId")
    private String userId;


    @OneToMany(mappedBy = "wallet", fetch = FetchType.LAZY)
    private List<Transaction> transactions;

    public Wallet(String userId) {
        this.userId = userId;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setWalletID(Long walletID) {
        this.walletID = walletID;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public Long getWalletID() {
        return walletID;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
