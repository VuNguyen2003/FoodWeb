package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dto.request.AccountRequest;
import com.AVfood.foodweb.models.Account;
import com.AVfood.foodweb.service.AccountService;
import com.AVfood.foodweb.exceptions.AccountExceptions; // Import lớp ngoại lệ chung
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AccountRequest accountRequest) {
        Account account = new Account();
        account.setUsername(accountRequest.getUsername());
        account.setPassword(accountRequest.getPassword()); // Mật khẩu nên được mã hóa trước khi lưu
        account.setFullName(accountRequest.getFullName());
        account.setEmail(accountRequest.getEmail());
        account.setAddress(accountRequest.getAddress());
        // Thêm logic để lưu tài khoản vào cơ sở dữ liệu
        accountService.saveAccount(account);
        return ResponseEntity.ok("Account registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Account account) {
        boolean isAuthenticated = accountService.authenticate(account.getUsername(), account.getPassword());
        if (!isAuthenticated) {
            throw new AccountExceptions.AuthenticationFailedException("Tên người dùng hoặc mật khẩu không đúng!");
        }
        return ResponseEntity.ok("Đăng nhập thành công!");
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
    public ResponseEntity<String> updateAccountInfo(@PathVariable String username, @RequestBody Account account) {
        boolean isUpdated = accountService.updateAccount(username, account);
        if (!isUpdated) {
            throw new AccountExceptions.AccountUpdateFailedException("Cập nhật không thành công!");
        }
        return ResponseEntity.ok("Cập nhật thông tin thành công!");
    }
}
