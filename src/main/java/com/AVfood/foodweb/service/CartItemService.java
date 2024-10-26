package com.AVfood.foodweb.service;

import com.AVfood.foodweb.reponsitorys.CartItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.AVfood.foodweb.models.*;
import java.util.List;

@Service
public class CartItemService {
    @Autowired
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Transactional
    public String addItemToCart(Long productId) {
        CartItem cartItem = new CartItem();
        cartItem.setProductId(productId);
        cartItemRepository.save(cartItem);  // Lưu giỏ hàng vào database
        return "Sản phẩm đã được thêm vào giỏ hàng!";
    }
    @Component
    public static class CartUtils {
        public String formatCartMessage(Long productId) {
            return "Sản phẩm có ID: " + productId;
        }
    }
    public String addItemToCart(Long productId, int quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setProductId(productId);
        cartItem.setQuantityItem(quantity);
        cartItemRepository.save(cartItem);  // Lưu mặt hàng vào giỏ
        return "Sản phẩm đã được thêm vào giỏ hàng!";
    }

    public List<CartItem> getItemsByProductId(Long productId) {
        return cartItemRepository.findAll();
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }
}
