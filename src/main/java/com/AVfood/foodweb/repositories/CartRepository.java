package com.AVfood.foodweb.repositories;

import com.AVfood.foodweb.models.Account;
import com.AVfood.foodweb.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {
    List<Cart> findByAccount_AccountId(Account accountId); // Finds carts by account ID
}
