package com.example.milestone1.repository;

import com.example.milestone1.entity.Transaction;
import com.example.milestone1.entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByWallet(Wallet wallet);
    Transaction findByTxnID(String txnID);
}
