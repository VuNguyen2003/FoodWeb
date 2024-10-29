package com.AVfood.foodweb.repositorys;

import com.AVfood.foodweb.models.Account;
import com.AVfood.foodweb.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
}
