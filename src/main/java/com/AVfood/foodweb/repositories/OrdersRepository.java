// OrdersRepository.java
package com.AVfood.foodweb.repositories;

import com.AVfood.foodweb.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, String> {
    List<Orders> findByAccountId(String accountId);
}
