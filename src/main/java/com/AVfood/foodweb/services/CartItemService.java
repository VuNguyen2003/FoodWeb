package com.AVfood.foodweb.services;

import com.AVfood.foodweb.dtos.request.CartItemRequest;
import com.AVfood.foodweb.repositories.CartItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.AVfood.foodweb.models.CartItem;

import java.util.List;
import java.util.UUID;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Transactional
    public String addItemToCart(String productId) {
        CartItem cartItem = new CartItem();
        cartItem.setProductId(productId);
        cartItemRepository.save(cartItem);  // Lưu giỏ hàng vào database
        return "Sản phẩm đã được thêm vào giỏ hàng!";
    }

    @Transactional
    public String addItemToCart(String productId, int quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setProductId(productId);
        cartItem.setQuantityItem(quantity); // Đảm bảo phương thức set đúng
        cartItemRepository.save(cartItem);  // Lưu mặt hàng vào giỏ
        return "Sản phẩm đã được thêm vào giỏ hàng!";
    }

    public List<CartItem> getItemsByProductId(String productId) {
        return cartItemRepository.findByProductId(productId); // Sử dụng phương thức tìm kiếm theo productId
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public void removeCartItem(String id) {
        cartItemRepository.deleteById(id);
    }

    public boolean existsById(String id) {
        return cartItemRepository.existsById(id);
    }

    @Transactional
    public void addCartItem(CartItemRequest itemRequest) {
        // Tạo một cartItemId duy nhất nếu chưa được cung cấp
        String cartItemId = itemRequest.getCartItemId();
        if (cartItemId == null || cartItemId.isEmpty()) {
            cartItemId = UUID.randomUUID().toString();
        }

        CartItem cartItem = new CartItem(
                cartItemId,
                itemRequest.getCartId(),
                String.valueOf(itemRequest.getProductId()), // Đảm bảo là String
                itemRequest.getQuantityItem(),
                itemRequest.getTotalItem()
        );

        cartItemRepository.save(cartItem);
    }

}
