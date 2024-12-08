package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.dtos.request.AccountRequest;
import com.AVfood.foodweb.dtos.request.UpdateAccountRequest; // DTO để cập nhật tài khoản
import com.AVfood.foodweb.models.Account;
import com.AVfood.foodweb.services.AccountService;
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

    /**
     * Đăng ký tài khoản mới
     * @param accountRequest - DTO chứa thông tin đăng ký tài khoản
     * @return ResponseEntity chứa thông báo đăng ký thành công hoặc lỗi
     */
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AccountRequest accountRequest) {
        // Kiểm tra xem tên người dùng đã tồn tại hay chưa
        if (accountService.findByUsername(accountRequest.getUsername()).isPresent()) {
            throw new AccountExceptions.AccountAlreadyExistsException("Tài khoản đã tồn tại với tên người dùng này!");
        }

        // Tạo tài khoản mới và gán các giá trị từ request
        Account account = new Account();
        account.setUsername(accountRequest.getUsername());
        account.setPassword(accountRequest.getPassword()); // Mã hóa mật khẩu sẽ được thực hiện trong service
        account.setFullName(accountRequest.getFullName());
        account.setEmail(accountRequest.getEmail());
        account.setAddress(accountRequest.getAddress());

        // Lưu tài khoản mới vào cơ sở dữ liệu thông qua service
        accountService.saveAccount(account);
        return ResponseEntity.ok("Account registered successfully");
    }

    /**
     * Đăng nhập tài khoản
     * @param accountRequest - DTO chứa thông tin đăng nhập tài khoản (username và password)
     * @return ResponseEntity chứa thông báo đăng nhập thành công hoặc lỗi
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AccountRequest accountRequest) {
        // Xác thực thông tin đăng nhập
        boolean isAuthenticated = accountService.authenticate(accountRequest.getUsername(), accountRequest.getPassword());
        if (!isAuthenticated) {
            throw new AccountExceptions.AuthenticationFailedException("Tên người dùng hoặc mật khẩu không đúng!");
        }

        // Tạo token và lưu vào hệ thống
        String token = accountService.generateToken(accountRequest.getUsername());
        return ResponseEntity.ok("Đăng nhập thành công! Token của bạn: " + token);
    }


    /**
     * Quên mật khẩu: gửi email để đặt lại mật khẩu
     * @param email - Địa chỉ email của tài khoản cần đặt lại mật khẩu
     * @return ResponseEntity chứa thông báo kết quả gửi email
     */
    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        // Gửi email đặt lại mật khẩu và nhận kết quả trả về
        boolean isEmailSent = accountService.sendPasswordResetEmail(email);

        // Kiểm tra nếu email không được gửi
        if (!isEmailSent) {
            throw new AccountExceptions.EmailNotFoundException("Không tìm thấy email trong hệ thống!");
        }

        return ResponseEntity.ok("Email để đặt lại mật khẩu đã được gửi!");
    }



    /**
     * Lấy thông tin tài khoản theo tên người dùng
     * @param username - Tên người dùng của tài khoản cần lấy thông tin
     * @return ResponseEntity chứa đối tượng Account hoặc lỗi nếu không tìm thấy tài khoản
     */
    @GetMapping("/{username}")
    public ResponseEntity<Account> getAccountInfo(
            @PathVariable String username,
            @RequestHeader("Authorization") String token) {
        // Kiểm tra token hợp lệ
        if (!accountService.validateToken(token, username)) {
            throw new AccountExceptions.AuthenticationFailedException("Token không hợp lệ hoặc đã hết hạn!");
        }

        // Tìm tài khoản theo username
        Optional<Account> account = accountService.findByUsername(username);
        return account.map(ResponseEntity::ok)
                .orElseThrow(() -> new AccountExceptions.AccountNotFoundException("Tài khoản không tìm thấy!"));
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
        // Kiểm tra token hợp lệ
        if (!accountService.validateToken(token, username)) {
            throw new AccountExceptions.AuthenticationFailedException("Token không hợp lệ hoặc đã hết hạn!");
        }

        // Lấy thông tin tài khoản hiện tại dựa trên username
        Account existingAccount = accountService.findByUsername(username)
                .orElseThrow(() -> new AccountExceptions.AccountNotFoundException("Tài khoản không tìm thấy!"));

        // Cập nhật thông tin từ updateRequest vào tài khoản hiện có
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

    @PostMapping("/logout")
    public ResponseEntity<String> logout(@RequestHeader("Authorization") String token) {
        boolean isLoggedOut = accountService.invalidateToken(token);
        if (!isLoggedOut) {
            throw new AccountExceptions.AuthenticationFailedException("Không thể đăng xuất, token không hợp lệ!");
        }
        return ResponseEntity.ok("Đăng xuất thành công!");
    }

    @PostMapping("/refresh-token")
    public ResponseEntity<String> refreshToken(@RequestHeader("Authorization") String oldToken) {
        String newToken = accountService.refreshToken(oldToken);
        if (newToken == null) {
            throw new AccountExceptions.AuthenticationFailedException("Token không hợp lệ hoặc đã hết hạn!");
        }
        return ResponseEntity.ok("Token mới của bạn: " + newToken);
    }

}
