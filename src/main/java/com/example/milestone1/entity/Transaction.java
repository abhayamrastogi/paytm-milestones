package com.example.milestone1.entity;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private Long ID;

    @Column(name = "description")
    private String description;

    @Column(name = "txn_id")
    private String txnID;

    @Column(name = "amount")
    private String amount;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id")
    private Payment payment;

    public Transaction() {
    }

    public Long getID() {
        return ID;
    }

    public String getDescription() {
        return description;
    }

    public String getTxnID() {
        return txnID;
    }

    public String getAmount() {
        return amount;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTxnID(String txnID) {
        this.txnID = txnID;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
