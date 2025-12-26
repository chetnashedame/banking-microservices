package com.bank.account_service.controller;

import com.bank.account_service.model.Account;
import com.bank.account_service.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<Account> create(@PathVariable Long userId) {
        return ResponseEntity.ok(service.createAccount(userId));
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<Account> get(@PathVariable Long accountId) {
        return ResponseEntity.ok(service.getAccount(accountId));
    }

    @PutMapping("/update/{accountId}/{amount}")
    public ResponseEntity<Account> update(
            @PathVariable Long accountId,
            @PathVariable Double amount
    ) {
        return ResponseEntity.ok(service.updateBalance(accountId, amount));
    }
}
