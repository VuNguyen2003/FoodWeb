package com.AVfood.foodweb.services;

import com.AVfood.foodweb.models.Token;
import com.AVfood.foodweb.repositories.TokenRepository;
import com.AVfood.foodweb.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Autowired
    private TokenUtil jwtTokenUtil;

    public Token createToken(String accountId) {
        String jwtToken = jwtTokenUtil.generateToken(accountId);

        Token token = new Token();
        token.setTokenId(jwtTokenUtil.getAccountIdFromToken(jwtToken));
        token.setTokenValue(jwtToken);
        token.setExpiryDate(LocalDateTime.now().plusDays(1)); // Token hết hạn sau 1 ngày
        tokenRepository.save(token);

        return token;
    }

    public Optional<Token> validateToken(String tokenValue) {
        Optional<Token> token = tokenRepository.findByTokenValue(tokenValue);
        if (token.isPresent() && jwtTokenUtil.validateToken(tokenValue)) {
            return token;
        }
        return Optional.empty();
    }
}
