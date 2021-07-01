package com.example.milestone1.service;

import com.example.milestone1.constants.ResponseCode;
import com.example.milestone1.error.WalletException;
import com.example.milestone1.entity.Wallet;
import com.example.milestone1.repository.TransactionRepository;
import com.example.milestone1.repository.WalletRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public WalletService(WalletRepository walletRepository, TransactionRepository transactionRepository) {
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
    }

    public List<Wallet> findAll() throws WalletException {
        return walletRepository.findAll();
    }

    public Wallet findById(@NotNull Long id) throws WalletException{
        Optional<Wallet> optionalWallet =  walletRepository.findById(id);
        if (!optionalWallet.isPresent()) {
            ResponseCode code = ResponseCode.RESOURCE_NOT_EXIST;
            throw new WalletException(code);
        }
        return  optionalWallet.get();
    }

    public List<Wallet> findByUserId(@NotNull String userId) throws WalletException{
        return  walletRepository.findByUserId(userId);
    }

    public Wallet createWallet(@NotNull String userId) throws WalletException {

        Wallet wallet = new Wallet(userId);
        walletRepository.save(wallet);
        return  walletRepository.save(wallet);
    }

    public Wallet updateWalletAmount(@NotNull Wallet wallet,@NotNull String amount) throws WalletException {
        wallet.setBalance(amount);
        walletRepository.save(wallet);
        return walletRepository.save(wallet);
    }
}
