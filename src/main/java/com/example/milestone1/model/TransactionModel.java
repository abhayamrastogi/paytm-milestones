package com.example.milestone1.model;

import org.jetbrains.annotations.NotNull;

public class TransactionModel {

    @NotNull()
    private String txnId;

    private String walletId;

    private String amount;

    private String description;
    private String paymentId;

    public TransactionModel(){}

    public TransactionModel( String txnId, String paymentId, String amount, String walletId, String description) {
        this.txnId = txnId;
        this.walletId = walletId;
        this.amount = amount;
        this.description = description;
        this.paymentId = paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setTxnId(@NotNull String txnId) {
        this.txnId = txnId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotNull
    public String getTxnId() {
        return txnId;
    }

    public String getWalletId() {
        return walletId;
    }

    public String getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
