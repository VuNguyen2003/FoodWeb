package com.AVfood.foodweb.repositorys;

import com.AVfood.foodweb.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByProductId(String productId);

//    // Tìm CartItem theo userId
//    List<CartItem> findByUserId(Long userId);
//
//    // Tìm CartItem theo price
//    List<CartItem> findByPriceLessThan(double price);
//
//    // Tìm CartItem theo quantity
//    List<CartItem> findByQuantityGreaterThan(int quantity);
//
//    // Tìm CartItem theo productId và userId
//    List<CartItem> findByProductIdAndUserId(Long productId, Long userId);
}
