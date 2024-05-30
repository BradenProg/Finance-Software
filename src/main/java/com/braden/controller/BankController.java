package com.braden.controller;

import com.braden.entity.Transactions;
import com.braden.entity.User;
import com.braden.repository.TransactionsRepository;
import com.braden.repository.UserRepository;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController // This means that this class is a Controller
@RequestMapping(path="/bank") // This means URL's start with /demo (after Application path)
public class BankController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private TransactionsRepository transactionsRepository;

    @PostMapping(path="/add/transaction") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam int senderId, @RequestParam int recipientId, @RequestParam float amount) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Transactions n = new Transactions();
        n.setRecipientId(recipientId);
        n.setSenderId(senderId);
        n.setAmount(amount);
        transactionsRepository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Transactions> getAllTransactions() {
        // This returns a JSON or XML with the users
        return transactionsRepository.findAll();
    }
}