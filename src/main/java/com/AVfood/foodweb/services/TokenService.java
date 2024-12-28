package com.AVfood.foodweb.services;

import com.AVfood.foodweb.exceptions.AccountExceptions;
import com.AVfood.foodweb.models.Account;
import com.AVfood.foodweb.models.Token;
import com.AVfood.foodweb.repositories.TokenRepository;
import com.AVfood.foodweb.repositories.AccountRepository;
import com.AVfood.foodweb.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class TokenService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TokenUtil jwtTokenUtil;

    @Autowired
    private TokenRepository tokenRepository;

    public Token createToken(String accountId) {
        String jwtToken = jwtTokenUtil.generateToken(accountId);

        Token token = new Token();
        token.setTokenId(UUID.randomUUID().toString()); // Tạo ID duy nhất cho token

        // Sử dụng accountRepository để tìm Account
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountExceptions.AccountNotFoundException("Không tìm thấy tài khoản với ID: " + accountId));

        token.setAccount(account); // Thiết lập đối tượng Account
        token.setTokenValue(jwtToken);
        token.setExpiryDate(LocalDateTime.now().plusDays(1)); // Token hết hạn sau 1 ngày
        tokenRepository.save(token);

        return token;
    }


    /**
     * Xác thực token
     * @param tokenValue - Token cần xác thực
     * @return Optional chứa token hợp lệ hoặc rỗng nếu không hợp lệ
     */
    public Optional<Token> validateToken(String tokenValue) {
        Optional<Token> tokenOpt = tokenRepository.findByTokenValue(tokenValue);
        if (tokenOpt.isPresent() && jwtTokenUtil.validateToken(tokenValue)) {
            Token token = tokenOpt.get();
            // Kiểm tra token chưa hết hạn và còn hoạt động
            if (token.isActive() && token.getExpiryDate().isAfter(LocalDateTime.now())) {
                return Optional.of(token);
            }
        }
        return Optional.empty();
    }

}
