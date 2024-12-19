package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dtos.request.AccountRequest;
import com.AVfood.foodweb.dtos.request.UpdateAccountRequest;
import com.AVfood.foodweb.models.Account;
import com.AVfood.foodweb.services.AccountService;
import com.AVfood.foodweb.services.TokenService;
import com.AVfood.foodweb.exceptions.AccountExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    private final AccountService accountService;
    private final TokenService tokenService;

    @Autowired
    public AccountController(AccountService accountService, TokenService tokenService) {
        this.accountService = accountService;
        this.tokenService = tokenService;
    }

    /**
     * Đăng ký tài khoản mới
     * @param accountRequest - DTO chứa thông tin đăng ký tài khoản
     * @return ResponseEntity chứa thông báo đăng ký thành công hoặc lỗi
     */
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

        accountService.saveAccount(account);
        return ResponseEntity.ok("Tài khoản đã được đăng ký thành công.");
    }

    /**
     * Đăng nhập tài khoản và tạo token
     * @param accountRequest - DTO chứa thông tin đăng nhập
     * @return ResponseEntity chứa token và thông báo
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AccountRequest accountRequest) {
        boolean isAuthenticated = accountService.authenticate(accountRequest.getUsername(), accountRequest.getPassword());
        if (!isAuthenticated) {
            throw new AccountExceptions.AuthenticationFailedException("Tên người dùng hoặc mật khẩu không đúng!");
        }

        // Tạo token
        var token = tokenService.createToken(accountRequest.getUsername());
        return ResponseEntity.ok("Đăng nhập thành công! Token của bạn: " + token.getTokenValue());
    }

    /**
     * Cập nhật thông tin tài khoản
     * @param username - Tên người dùng của tài khoản cần cập nhật
     * @param updateRequest - DTO chứa thông tin cập nhật tài khoản
     * @return ResponseEntity chứa thông báo cập nhật thành công hoặc lỗi
     */
    @PutMapping("/{username}")
    public ResponseEntity<String> updateAccountInfo(
            @PathVariable String username,
            @RequestBody UpdateAccountRequest updateRequest,
            @RequestHeader("Authorization") String token) {

        if (!tokenService.validateToken(token).isPresent()) {
            throw new AccountExceptions.AuthenticationFailedException("Token không hợp lệ hoặc đã hết hạn!");
        }

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
