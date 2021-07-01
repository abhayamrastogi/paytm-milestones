package com.example.milestone1.controller;

import com.example.milestone1.error.WalletException;
import com.example.milestone1.entity.Wallet;
import com.example.milestone1.model.WalletModel;
import com.example.milestone1.service.WalletService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class WalletController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WalletService walletService;

    @GetMapping(
            value = "/wallet/test",
            produces = MediaType.TEXT_PLAIN_VALUE
    )

    @ResponseBody
    public String test() throws WalletException, ClassNotFoundException {
        return "Hello from wallet microservice!";
    }

    @GetMapping(
            value = "/wallets",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public List<Wallet> getAll() throws WalletException, ClassNotFoundException {
        logger.debug("Called WalletController.getAll");
        return walletService.findAll();
    }
    @GetMapping(
            value = "/wallets/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )

    @ResponseBody
    public Wallet getWalletById( @PathVariable("id") Long id) throws WalletException, ClassNotFoundException {
        logger.debug("Called WalletController.getWalletById with id={}",id);
        Wallet wallet = walletService.findById(id);
        return wallet;
    }

    @GetMapping(
            value = "/wallets/user",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public List<Wallet> getWalletsByUserId( @RequestParam("userId") String userId) throws WalletException, ClassNotFoundException {
        logger.debug("Called WalletController.getWalletsByUserId with userId={}",userId);
        List<Wallet> wallets = walletService.findByUserId(userId);
        return wallets;
    }

    @PostMapping(value = "/wallets",  produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Wallet createWallet(@RequestBody WalletModel wallet) throws WalletException {
        logger.debug("Called WalletController.createWallet");
        return walletService.createWallet(wallet.getUserId());
    }
}
