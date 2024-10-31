package com.AVfood.foodweb.repositorys;

import com.AVfood.foodweb.models.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, String> {
    // Additional query methods if needed
}
