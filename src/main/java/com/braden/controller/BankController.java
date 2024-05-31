package com.braden.controller;

import com.braden.entity.Transactions;
import com.braden.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // This means that this class is a Controller
@RequestMapping(path="/bank") // This means URL's start with /demo (after Application path)
public class BankController {

    private final TransactionService transactionService;

    @Autowired
    public BankController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    @PostMapping(path="/add/transaction") // Map ONLY POST Requests
    public @ResponseBody String addTransaction (@RequestParam int senderId, @RequestParam int recipientId, @RequestParam float amount) {

        Transactions transaction = new Transactions();
        transaction.createTransaction(senderId, recipientId, amount);

        try {
            transactionService.updateUserBalances(transaction);
        } catch (Exception e) {
            return String.format("Failed due to %s",e);
        }
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Transactions> getAllTransactions() {
        // This returns a JSON or XML with the users
        return transactionService.getAllTransactions();
    }
}