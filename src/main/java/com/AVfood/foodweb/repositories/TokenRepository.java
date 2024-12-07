package com.AVfood.foodweb.repositories;

import com.AVfood.foodweb.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, String> {
    Optional<Token> findByTokenValue(String tokenValue);

    Optional<Token> findByAccount_AccountIdAndIsActiveTrue(String accountId);
}
