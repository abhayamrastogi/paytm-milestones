package com.example.milestone1.controller;

import com.example.milestone1.error.WalletException;
import com.example.milestone1.entity.Transaction;
import com.example.milestone1.model.TransactionModel;
import com.example.milestone1.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/transaction")
public class TransactionController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TransactionService transactionService;

    @GetMapping(
            value = "/wallets/{id}/transactions",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public List<Transaction> getWalletTransactionsById(@PathVariable("id") Long id) throws WalletException, ClassNotFoundException {
        logger.debug("Called TransactionController.getWalletTransactionsById with parameter walletId={}",id);
        return transactionService.getTransactionByWalletId(id);
    }

    @PostMapping(
            value = "/transactions",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public Transaction createWalletTransaction( @RequestBody TransactionModel transaction) throws WalletException, ClassNotFoundException {
        logger.debug("Called TransactionController.createWalletTransaction" );

        Transaction paytm_transaction = transactionService.createTransaction(transaction.getTxnId(),transaction.getPaymentId(), transaction.getWalletId(),
                transaction.getAmount(),transaction.getDescription());
        logger.info("Transaction created with id=" + paytm_transaction.getID());

        return paytm_transaction;
    }
}
