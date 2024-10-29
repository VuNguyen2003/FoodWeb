package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dto.request.AccountRequest;
import com.AVfood.foodweb.dto.request.UpdateAccountRequest; // DTO để cập nhật tài khoản
import com.AVfood.foodweb.models.Account;
import com.AVfood.foodweb.service.AccountService;
import com.AVfood.foodweb.exceptions.AccountExceptions; // Import lớp ngoại lệ
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
        if (accountService.findByUsername(accountRequest.getUsername()).isPresent()) {
            throw new AccountExceptions.AccountAlreadyExistsException("Tài khoản đã tồn tại với tên người dùng này!");
        }

        Account account = new Account();
        account.setUsername(accountRequest.getUsername());
        account.setPassword(accountRequest.getPassword()); // Mã hóa mật khẩu sẽ được thực hiện trong service
        account.setFullName(accountRequest.getFullName());
        account.setEmail(accountRequest.getEmail());
        account.setAddress(accountRequest.getAddress());

        accountService.saveAccount(account); // Lưu tài khoản vào cơ sở dữ liệu
        return ResponseEntity.ok("Account registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AccountRequest accountRequest) {
        boolean isAuthenticated = accountService.authenticate(accountRequest.getUsername(), accountRequest.getPassword());
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
    public ResponseEntity<String> updateAccountInfo(@PathVariable String username, @RequestBody UpdateAccountRequest updateRequest) {
        Account existingAccount = accountService.findByUsername(username)
                .orElseThrow(() -> new AccountExceptions.AccountNotFoundException("Tài khoản không tìm thấy!"));

        // Cập nhật thông tin tài khoản
        existingAccount.setFullName(updateRequest.getFullName());
        existingAccount.setEmail(updateRequest.getEmail());
        existingAccount.setAddress(updateRequest.getAddress());

        if (updateRequest.getPassword() != null && !updateRequest.getPassword().isEmpty()) {
            existingAccount.setPassword(updateRequest.getPassword()); // Lưu mật khẩu mới chưa mã hóa
        }

        boolean isUpdated = accountService.updateAccount(username, existingAccount);
        if (!isUpdated) {
            throw new AccountExceptions.AccountUpdateFailedException("Cập nhật không thành công!");
        }
        return ResponseEntity.ok("Cập nhật thông tin thành công!");
    }
}
