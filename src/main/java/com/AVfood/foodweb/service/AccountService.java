package com.AVfood.foodweb.service;

import com.AVfood.foodweb.models.Account; // Import lớp Account
import com.AVfood.foodweb.repositorys.AccountRepository; // Import lớp AccountRepository
import org.springframework.beans.factory.annotation.Autowired; // Import Annotation Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Import BCryptPasswordEncoder
import org.springframework.stereotype.Service; // Import Annotation Service

import java.util.Optional; // Import Optional

@Service // Đánh dấu lớp này là một service của Spring
public class AccountService {

    private final AccountRepository accountRepository; // Repository để truy vấn tài khoản từ cơ sở dữ liệu
    private final BCryptPasswordEncoder passwordEncoder; // Mã hóa mật khẩu

    // Constructor để inject AccountRepository và BCryptPasswordEncoder
    @Autowired
    public AccountService(AccountRepository accountRepository, BCryptPasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder; // Inject BCryptPasswordEncoder
    }

    // Phương thức để lưu tài khoản sau khi mã hóa mật khẩu
    public void saveAccount(Account account) {
        String encodedPassword = passwordEncoder.encode(account.getPassword()); // Mã hóa mật khẩu
        account.setPassword(encodedPassword); // Gán mật khẩu đã mã hóa cho tài khoản
        accountRepository.save(account); // Lưu tài khoản vào cơ sở dữ liệu
    }

    // Phương thức để đăng ký tài khoản mới
    public boolean register(Account account) {
        // Kiểm tra xem tài khoản đã tồn tại hay chưa
        // Logic kiểm tra tài khoản tồn tại có thể được thực hiện ở đây
        saveAccount(account); // Lưu tài khoản mới vào cơ sở dữ liệu
        return true; // Trả về true nếu đăng ký thành công
    }

    // Phương thức để xác thực tài khoản
    public boolean authenticate(String username, String password) {
        // Tìm tài khoản theo tên người dùng
        Optional<Account> accountOpt = findByUsername(username);

        // Nếu không tìm thấy tài khoản, trả về false
        if (accountOpt.isEmpty()) {
            return false;
        }

        // Lấy tài khoản từ Optional
        Account account = accountOpt.get();

        // Kiểm tra mật khẩu
        return passwordEncoder.matches(password, account.getPassword()); // So sánh mật khẩu đã mã hóa
    }

    // Phương thức để gửi email đặt lại mật khẩu
    public boolean sendPasswordResetEmail(String email) {
        // Logic gửi email ở đây
        return true; // Trả về true nếu gửi email thành công
    }

    // Phương thức tìm tài khoản theo tên người dùng
    public Optional<Account> findByUsername(String username) {
        // Tìm tài khoản trong cơ sở dữ liệu
        return accountRepository.findByUsername(username); // Giả định phương thức này tồn tại trong AccountRepository
    }

    // Phương thức cập nhật thông tin tài khoản
    public boolean updateAccount(String username, Account account) {
        // Logic cập nhật thông tin tài khoản
        return true; // Trả về true nếu cập nhật thành công
    }
}
