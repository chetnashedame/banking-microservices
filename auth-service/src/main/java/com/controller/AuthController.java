package com.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody Map<String, String> request) {
        return Map.of("message", "User registered");
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> request) {
        return Map.of("token", "dummy-jwt-token");
    }
}
