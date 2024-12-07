package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dtos.response.tokenResponse;
import com.AVfood.foodweb.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    @PostMapping("/token")
    public ResponseEntity<tokenResponse> generateToken(@RequestParam String accountId) {
        var token = tokenService.createToken(accountId);
        return ResponseEntity.ok(new tokenResponse(token.getTokenValue(), token.getExpiryDate()));
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestParam String tokenValue) {
        var token = tokenService.validateToken(tokenValue);
        return token.isPresent()
                ? ResponseEntity.ok("Token is valid")
                : ResponseEntity.status(401).body("Invalid token");
    }
}
