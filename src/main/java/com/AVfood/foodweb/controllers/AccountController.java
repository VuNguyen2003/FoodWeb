package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.models.Account; // Thay đổi từ User thành Account
import com.AVfood.foodweb.service.AccountService; // Thay đổi từ UserService thành AccountService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService; // Thay đổi từ UserService thành AccountService

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService; // Cập nhật constructor
    }

    // Đăng ký tài khoản mới
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Account account) { // Thay đổi từ User thành Account
        boolean isRegistered = accountService.register(account); // Cập nhật dịch vụ
        if (isRegistered) {
            return ResponseEntity.ok("Đăng ký thành công!");
        } else {
            return ResponseEntity.status(400).body("Tên người dùng đã tồn tại!");
        }
    }

    // Đăng nhập
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Account account) { // Thay đổi từ User thành Account
        boolean isAuthenticated = accountService.authenticate(account.getUsername(), account.getPassword()); // Cập nhật dịch vụ
        if (isAuthenticated) {
            return ResponseEntity.ok("Đăng nhập thành công!");
        } else {
            return ResponseEntity.status(401).body("Tên người dùng hoặc mật khẩu không đúng!");
        }
    }

    // Quên mật khẩu
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        boolean isEmailSent = accountService.sendPasswordResetEmail(email); // Cập nhật dịch vụ
        if (isEmailSent) {
            return ResponseEntity.ok("Email để đặt lại mật khẩu đã được gửi!");
        } else {
            return ResponseEntity.status(400).body("Không tìm thấy email trong hệ thống!");
        }
    }

    // Lấy thông tin tài khoản
    @GetMapping("/{username}")
    public ResponseEntity<Account> getAccountInfo(@PathVariable String username) { // Thay đổi từ User thành Account
        Optional<Account> account = accountService.findByUsername(username); // Cập nhật dịch vụ
        return account.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Cập nhật thông tin tài khoản
    @PutMapping("/{username}")
    public ResponseEntity<String> updateAccountInfo(@PathVariable String username, @RequestBody Account account) { // Thay đổi từ User thành Account
        boolean isUpdated = accountService.updateAccount(username, account); // Cập nhật dịch vụ
        if (isUpdated) {
            return ResponseEntity.ok("Cập nhật thông tin thành công!");
        } else {
            return ResponseEntity.status(400).body("Cập nhật không thành công!");
        }
    }
}
