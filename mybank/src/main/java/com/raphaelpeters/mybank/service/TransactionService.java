package com.raphaelpeters.mybank.service;

import com.raphaelpeters.mybank.model.Transaction;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class TransactionService {

    private Map<String, Transaction> transactions = new HashMap<>();

    public TransactionService() {
    }

    public List<Transaction> getAllTransactions() {
        return transactions.entrySet().stream()
                .map(Map.Entry::getValue)
                .toList();
    }

    public Optional<Transaction> getTransaction(String id) {
        return transactions.entrySet().stream()
                .filter(e -> id.equalsIgnoreCase(e.getKey()))
                .map(Map.Entry::getValue)
                .findFirst();
    }

    public Transaction createTransaction(String id, int amount, String timestamp, String reference) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(timestamp, dateTimeFormatter);
        Transaction transaction = new Transaction(id, amount, dateTime, reference);
        transactions.put(id, transaction);
        return transaction;
    }
}
