// src/controllers/AccountController.java
package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dtos.request.AccountRequest;
import com.AVfood.foodweb.dtos.request.UpdateAccountRequest;
import com.AVfood.foodweb.models.Account;
import com.AVfood.foodweb.services.AccountService;
import com.AVfood.foodweb.exceptions.AccountExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/account")
@CrossOrigin(origins = "http://localhost:3000")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody AccountRequest accountRequest) {
        if (accountService.findByUsername(accountRequest.getUsername()).isPresent()) {
            throw new AccountExceptions.AccountAlreadyExistsException("Tài khoản đã tồn tại với tên người dùng này!");
        }

        Account account = new Account();
        account.setUsername(accountRequest.getUsername());
        account.setPassword(accountRequest.getPassword());
        account.setFullName(accountRequest.getFullName());
        account.setEmail(accountRequest.getEmail());
        account.setAddress(accountRequest.getAddress());

        accountService.saveAccount(account);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Account registered successfully");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody AccountRequest accountRequest) {
        boolean isAuthenticated = accountService.authenticate(accountRequest.getUsername(), accountRequest.getPassword());

        Map<String, String> response = new HashMap<>();
        if (isAuthenticated) {
            response.put("message", "Đăng nhập thành công!");
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Tên đăng nhập hoặc mật khẩu không đúng!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        boolean isEmailSent = accountService.sendPasswordResetEmail(email);
        if (!isEmailSent) {
            throw new AccountExceptions.EmailNotFoundException("Không tìm thấy email trong hệ thống!");
        }
        return ResponseEntity.ok("Email để đặt lại mật khẩu đã được gửi!");
    }

    @GetMapping("/{username}")
    public ResponseEntity<Account> getAccountInfo(@PathVariable String username) {
        Optional<Account> account = accountService.findByUsername(username);
        return account.map(ResponseEntity::ok)
                .orElseThrow(() -> new AccountExceptions.AccountNotFoundException("Tài khoản không tìm thấy!"));
    }

    @PutMapping("/{username}")
    public ResponseEntity<String> updateAccountInfo(@PathVariable String username, @RequestBody UpdateAccountRequest updateRequest) {
        Account existingAccount = accountService.findByUsername(username)
                .orElseThrow(() -> new AccountExceptions.AccountNotFoundException("Tài khoản không tìm thấy!"));

        existingAccount.setFullName(updateRequest.getFullName());
        existingAccount.setEmail(updateRequest.getEmail());
        existingAccount.setAddress(updateRequest.getAddress());

        if (updateRequest.getPassword() != null && !updateRequest.getPassword().isEmpty()) {
            existingAccount.setPassword(updateRequest.getPassword());
        }

        boolean isUpdated = accountService.updateAccount(username, existingAccount);
        if (!isUpdated) {
            throw new AccountExceptions.AccountUpdateFailedException("Cập nhật không thành công!");
        }

        return ResponseEntity.ok("Cập nhật thông tin thành công!");
    }
}