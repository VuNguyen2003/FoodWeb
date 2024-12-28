package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dtos.response.TokenResponse;
import com.AVfood.foodweb.models.Token;
import com.AVfood.foodweb.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private TokenService tokenService;

    /**
     * Tạo token mới cho tài khoản
     * @param accountId - ID của tài khoản muốn tạo token
     * @return ResponseEntity chứa token và thời gian hết hạn
     */
    @PostMapping("/token")
    public ResponseEntity<TokenResponse> generateToken(@RequestParam String accountId) {
        Token token = tokenService.createToken(accountId);
        return ResponseEntity.ok(new TokenResponse(token.getTokenValue(), token.getExpiryDate()));
    }

    /**
     * Kiểm tra tính hợp lệ của token
     * @param tokenValue - Token cần kiểm tra
     * @return ResponseEntity với thông báo trạng thái hợp lệ hoặc không hợp lệ
     */
    @GetMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestParam String tokenValue) {
        var token = tokenService.validateToken(tokenValue);
        return token.isPresent()
                ? ResponseEntity.ok("Token hợp lệ")
                : ResponseEntity.status(401).body("Token không hợp lệ");
    }
}
