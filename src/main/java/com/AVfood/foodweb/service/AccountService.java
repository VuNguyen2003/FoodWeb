package com.AVfood.foodweb.service;

import com.AVfood.foodweb.exceptions.AccountExceptions;
import com.AVfood.foodweb.models.Account; // Import lớp Account
import com.AVfood.foodweb.repositorys.AccountRepository; // Import lớp AccountRepository
import org.springframework.beans.factory.annotation.Autowired; // Import Annotation Autowired
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Import BCryptPasswordEncoder
import org.springframework.stereotype.Service; // Import Annotation Service

import java.util.Optional; // Import Optional
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger; // Import AtomicInteger

@Service // Đánh dấu lớp này là một service của Spring
public class AccountService {

    private final AccountRepository accountRepository; // Repository để truy vấn tài khoản từ cơ sở dữ liệu
    private final BCryptPasswordEncoder passwordEncoder; // Mã hóa mật khẩu
    private final AtomicInteger counter = new AtomicInteger(0); // Đếm số lượng ID tạo ra trong một giây

    // Constructor để inject AccountRepository và BCryptPasswordEncoder
    @Autowired
    public AccountService(AccountRepository accountRepository, BCryptPasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository; // Inject AccountRepository
        this.passwordEncoder = passwordEncoder; // Inject BCryptPasswordEncoder
    }


    private String generateUniqueId() {
        return UUID.randomUUID().toString(); // Tạo UUID và chuyển đổi thành chuỗi
    }


    // Phương thức để lưu tài khoản sau khi mã hóa mật khẩu
    public void saveAccount(Account account) {
        try {
            // Kiểm tra xem username đã tồn tại chưa
            if (accountRepository.existsByUsername(account.getUsername())) {
                throw new AccountExceptions.AccountAlreadyExistsException("Username đã tồn tại.");
            }

            // Tạo ID và mã hóa mật khẩu
            String uniqueId = generateUniqueId();
            account.setAccountId(uniqueId);
            String encodedPassword = passwordEncoder.encode(account.getPassword());
            account.setPassword(encodedPassword);

            // Lưu tài khoản mới
            accountRepository.save(account);
        } catch (DataIntegrityViolationException e) {
            throw new AccountExceptions.AccountUpdateFailedException("Xung đột ID xảy ra khi lưu tài khoản.");
        }
    }



    // Phương thức để đăng ký tài khoản mới
    public boolean register(Account account) {
        // Kiểm tra xem tài khoản đã tồn tại hay chưa
        if (accountRepository.findByUsername(account.getUsername()).isPresent()) {
            return false; // Trả về false nếu tài khoản đã tồn tại
        }
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
        // Logic gửi email có thể được thực hiện tại đây
        // Nếu bạn có thể sử dụng một dịch vụ gửi email, hãy gọi nó ở đây
        return true; // Trả về true nếu gửi email thành công
    }

    // Phương thức tìm tài khoản theo tên người dùng
    public Optional<Account> findByUsername(String username) {
        // Tìm tài khoản trong cơ sở dữ liệu
        return accountRepository.findByUsername(username); // Giả định phương thức này tồn tại trong AccountRepository
    }

    // Phương thức cập nhật thông tin tài khoản
    public boolean updateAccount(String username, Account updatedAccount) {
        Optional<Account> existingAccountOpt = findByUsername(username);

        // Kiểm tra nếu tài khoản đã tồn tại
        if (existingAccountOpt.isPresent()) {
            Account existingAccount = existingAccountOpt.get();
            // Cập nhật thông tin tài khoản
            existingAccount.setEmail(updatedAccount.getEmail());
            existingAccount.setFullName(updatedAccount.getFullName());
            // Gán mật khẩu đã mã hóa nếu có thay đổi
            if (updatedAccount.getPassword() != null && !updatedAccount.getPassword().isEmpty()) {
                existingAccount.setPassword(passwordEncoder.encode(updatedAccount.getPassword()));
            }
            // Lưu tài khoản đã cập nhật vào cơ sở dữ liệu
            accountRepository.save(existingAccount);
            return true; // Trả về true nếu cập nhật thành công
        }
        return false; // Trả về false nếu không tìm thấy tài khoản
    }
}
