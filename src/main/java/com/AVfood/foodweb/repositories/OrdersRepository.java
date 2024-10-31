package com.AVfood.foodweb.repositories;

import com.AVfood.foodweb.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String> {
    // Additional query methods if needed
}
