package com.bank.account_service.service;

import com.bank.account_service.model.Account;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AccountService {

    private final Map<Long, Account> store = new ConcurrentHashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public Account createAccount(Long userId) {
        Account acc = new Account();
        acc.setId(idGen.getAndIncrement());
        acc.setUserId(userId);
        acc.setBalance(0.0);
        acc.setStatus("ACTIVE");

        store.put(acc.getId(), acc);
        return acc;
    }

    public Account getAccount(Long accountId) {
        return store.get(accountId);
    }

    public Account updateBalance(Long accountId, Double amount) {
        Account acc = store.get(accountId);
        acc.setBalance(acc.getBalance() + amount);
        return acc;
    }
}
