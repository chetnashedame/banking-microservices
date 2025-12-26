package com.bank.transaction_service.controller;

import com.bank.transaction_service.dto.TransactionRequest;
import com.bank.transaction_service.model.Transaction;
import com.bank.transaction_service.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("/deposit")
    public ResponseEntity<String> deposit(
            @RequestBody TransactionRequest request
    ) {
        return ResponseEntity.ok(
            service.deposit(request.getAccountId(), request.getAmount())
        );
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        // Replace with actual service logic
        return ResponseEntity.ok(new ArrayList<>());
    }
}
