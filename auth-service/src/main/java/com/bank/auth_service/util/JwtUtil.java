package com.bank.auth_service.util;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String username) {
        // TEMP TOKEN — real JWT comes next step
        return "token-for-" + username;
    }
}
