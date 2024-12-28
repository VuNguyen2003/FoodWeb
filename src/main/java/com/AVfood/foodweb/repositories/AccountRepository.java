package com.AVfood.foodweb.repositories;

import com.AVfood.foodweb.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByUsername(String username);
    boolean existsByUsername(String username);
    Optional<Account> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<Account> findByAccountId(String accountId);
    boolean existsByAccountId(String accountId);
}

