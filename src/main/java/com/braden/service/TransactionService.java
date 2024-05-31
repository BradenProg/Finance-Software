package com.braden.service;

import com.braden.entity.Transactions;
import com.braden.entity.User;
import com.braden.repository.TransactionsRepository;
import com.braden.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
public class TransactionService {

    private final UserRepository userRepository;

    private final TransactionsRepository transactionsRepository;

    @Autowired
    public TransactionService(UserRepository userRepository, TransactionsRepository transactionsRepository) {
        this.userRepository = userRepository;
        this.transactionsRepository = transactionsRepository;

    }

    @Transactional
    public void updateUserBalances(Transactions transaction) throws Exception {
        User sender = userRepository.findById(transaction.getSenderId())
                    .orElseThrow(() -> new Exception("Sender not found"));
        User recipient = userRepository.findById(transaction.getRecipientId())
                    .orElseThrow(() -> new Exception("Recipient not found"));

        sender.decreaseBankBalance(transaction.getAmount());
        recipient.increaseBankBalance(transaction.getAmount());

        userRepository.save(sender);
        userRepository.save(recipient);

        transactionsRepository.save(transaction);
    }

    @Transactional
    public @ResponseBody Iterable<Transactions> getAllTransactions() {
        return transactionsRepository.findAll();
    }
}
