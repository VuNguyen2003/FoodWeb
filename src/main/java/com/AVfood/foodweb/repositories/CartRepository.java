package com.AVfood.foodweb.repositories;

import com.AVfood.foodweb.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> {
    // Additional query methods if needed
}
