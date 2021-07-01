package com.example.milestone1.service;

import com.example.milestone1.constants.ResponseCode;
import com.example.milestone1.error.WalletException;
import com.example.milestone1.entity.Transaction;
import com.example.milestone1.entity.Wallet;
import com.example.milestone1.repository.TransactionRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private WalletService walletService;

    public List<Transaction> getTransactionByWalletId(@NotNull Long walletId) throws WalletException {

        Wallet wallet = walletService.findById(walletId);
        if(wallet != null) {
            return  transactionRepository.findByWallet(wallet);
        }else {
            ResponseCode walletCode = ResponseCode.SERVICE_ERROR;
            throw new WalletException(walletCode);
        }
    }

    public Transaction createTransaction(@NotNull String txnId, @NotNull String paymentId, @NotNull String walletId, @NotNull String amount, String description) throws WalletException{
        try {
            //Check wallet is present
            Wallet wallet = walletService.findById(Long.valueOf(walletId));
            walletService.updateWalletAmount(wallet, amount);

            //Create transaction
            Transaction transaction = new Transaction();
            transaction.setTxnID(txnId);
            transaction.setAmount(amount);
            transaction.setDescription(description);
            return transactionRepository.save(transaction);
        }catch (Exception e){
            ResponseCode walletCode = ResponseCode.SERVICE_ERROR;
            throw new WalletException(walletCode);
        }
    }

}
