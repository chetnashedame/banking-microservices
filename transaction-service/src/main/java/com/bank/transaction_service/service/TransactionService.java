package com.bank.transaction_service.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TransactionService {

    private final RestTemplate restTemplate;

    public TransactionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String deposit(Long accountId, Double amount) {
        String url =
            "http://ACCOUNT-SERVICE/accounts/update/" + accountId + "/" + amount;

        restTemplate.put(url, null);
        return "Deposit successful";
    }
}
