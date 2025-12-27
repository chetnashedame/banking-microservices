package com.bank.auth_service.controller;

import com.bank.auth_service.dto.LoginRequest;
import com.bank.auth_service.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {

        // Dummy validation for now
        if (!"user".equals(request.getUsername()) ||
            !"password".equals(request.getPassword())) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }

        String token = jwtUtil.generateToken(request.getUsername());

        return ResponseEntity.ok(
                Map.of(
                        "username", request.getUsername(),
                        "token", token
                )
        );
    }
}
