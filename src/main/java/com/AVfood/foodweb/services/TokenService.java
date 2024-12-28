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
    private TokenRepository tokenRepository;

    @Autowired
    private TokenUtil jwtTokenUtil;

    @Autowired
    private AccountRepository accountRepository;

    public Token createToken(String accountId) {
        String jwtToken = jwtTokenUtil.generateToken(accountId);

        Token token = new Token();
        token.setTokenId(UUID.randomUUID().toString());
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountExceptions.AccountNotFoundException("Không tìm thấy tài khoản với ID: " + accountId));

        token.setAccount(account);
        token.setTokenValue(jwtToken);
        token.setExpiryDate(LocalDateTime.now().plusDays(1));
        tokenRepository.save(token);

        return token;
    }

    public Optional<Token> validateToken(String tokenValue) {
        Optional<Token> tokenOpt = tokenRepository.findByTokenValue(tokenValue);
        if (tokenOpt.isPresent() && jwtTokenUtil.validateToken(tokenValue)) {
            Token token = tokenOpt.get();
            if (token.isActive() && token.getExpiryDate().isAfter(LocalDateTime.now())) {
                return Optional.of(token);
            }
        }
        return Optional.empty();
    }
}
