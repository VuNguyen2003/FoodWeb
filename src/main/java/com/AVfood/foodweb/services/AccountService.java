package com.AVfood.foodweb.services;

import com.AVfood.foodweb.exceptions.AccountExceptions;
import com.AVfood.foodweb.exceptions.EmailSendingFailedException;
import com.AVfood.foodweb.models.Account;
import com.AVfood.foodweb.models.Token;
import com.AVfood.foodweb.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final JavaMailSender mailSender;

    @Autowired
    public AccountService(AccountRepository accountRepository,
                          BCryptPasswordEncoder passwordEncoder,
                          TokenService tokenService,
                          JavaMailSender mailSender) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
        this.mailSender = mailSender;
    }

    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    public Account createAccount(Account account) {
        account.setAccountId(UUID.randomUUID().toString());
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return accountRepository.save(account);
    }
    public boolean authenticate(String username, String password) {
        // Tìm tài khoản theo username
        Optional<Account> accountOptional = accountRepository.findByUsername(username);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            // So sánh mật khẩu người dùng nhập vào với mật khẩu lưu trong cơ sở dữ liệu
            return passwordEncoder.matches(password, account.getPassword());
        }
        return false; // Trả về false nếu không tìm thấy tài khoản
    }

    public boolean updateAccount(String username, Account updatedAccount) {
        Optional<Account> existingAccountOptional = accountRepository.findByUsername(username);

        if (existingAccountOptional.isPresent()) {
            Account existingAccount = existingAccountOptional.get();

            // Cập nhật thông tin tài khoản
            existingAccount.setFullName(updatedAccount.getFullName());
            existingAccount.setEmail(updatedAccount.getEmail());
            existingAccount.setAddress(updatedAccount.getAddress());

            // Nếu mật khẩu không trống, mã hóa mật khẩu mới và cập nhật
            if (updatedAccount.getPassword() != null && !updatedAccount.getPassword().isEmpty()) {
                existingAccount.setPassword(passwordEncoder.encode(updatedAccount.getPassword()));
            }

            // Lưu tài khoản đã cập nhật vào cơ sở dữ liệu
            accountRepository.save(existingAccount);
            return true;
        }
        return false; // Trả về false nếu không tìm thấy tài khoản
    }

    // Đăng nhập và tạo token
    public String authenticateAndGenerateToken(String username, String password) {
        Optional<Account> accountOpt = accountRepository.findByUsername(username);

        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();

            if (passwordEncoder.matches(password, account.getPassword())) {
                Token token = tokenService.createToken(account.getAccountId());
                return token.getTokenValue();
            }
        }

        throw new AccountExceptions.AuthenticationFailedException("Tên người dùng hoặc mật khẩu không đúng!");
    }

    // Xác thực token
    public boolean validateToken(String tokenValue, String accountId) {
        Optional<Token> tokenOpt = tokenService.validateToken(tokenValue);

        if (tokenOpt.isPresent()) {
            return tokenOpt.get().getTokenId().equals(accountId);
        }

        return false;
    }

    // Gửi email đặt lại mật khẩu
    public boolean sendPasswordResetEmail(String email) {
        Optional<Account> accountOpt = accountRepository.findByEmail(email);

        if (accountOpt.isEmpty()) {
            throw new AccountExceptions.EmailNotFoundException("Email không tồn tại trong hệ thống!");
        }

        Account account = accountOpt.get();
        Token resetToken = tokenService.createToken(account.getAccountId());

        // Tạo liên kết đặt lại mật khẩu
        String resetLink = "https://your-website.com/reset-password?token=" + resetToken.getTokenValue();

        // Gửi email qua JavaMailSender
        try {
            sendEmail(email, "Password Reset Request",
                    "Dear " + account.getFullName() + ",\n\n" +
                            "We received a request to reset your password. Please click the link below to reset your password:\n" +
                            resetLink + "\n\n" +
                            "If you did not request this, please ignore this email.\n\n" +
                            "Best regards,\nYour Team"
            );
            return true;
        } catch (Exception e) {
            throw new EmailSendingFailedException("Không thể gửi email đặt lại mật khẩu!");
        }
    }

    // Đặt lại mật khẩu
    public boolean resetPassword(String tokenValue, String newPassword) {
        Optional<Token> tokenOpt = tokenService.validateToken(tokenValue);

        if (tokenOpt.isEmpty()) {
            throw new AccountExceptions.AuthenticationFailedException("Token không hợp lệ hoặc đã hết hạn!");
        }

        Token token = tokenOpt.get();
        Optional<Account> accountOpt = accountRepository.findById(token.getTokenId());

        if (accountOpt.isPresent()) {
            Account account = accountOpt.get();
            account.setPassword(passwordEncoder.encode(newPassword));
            accountRepository.save(account);
            return true;
        }

        throw new AccountExceptions.AuthenticationFailedException("Tài khoản không tồn tại!");
    }

    private void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
    public Account getAccountById(String accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountExceptions.AccountNotFoundException("Account not found"));
    }

}
