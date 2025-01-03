package com.AVfood.foodweb.services;

import com.AVfood.foodweb.dtos.request.CartRequest;
import com.AVfood.foodweb.models.Account;
import com.AVfood.foodweb.models.Cart;
import com.AVfood.foodweb.models.CartItem;
import com.AVfood.foodweb.models.Status;
import com.AVfood.foodweb.repositories.AccountRepository;
import com.AVfood.foodweb.repositories.CartRepository;
import com.AVfood.foodweb.repositories.StatusRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.AVfood.foodweb.repositories.*;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    public Cart createCart(CartRequest request) {
        Account account = accountRepository.findById(request.getAccountId())
                .orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + request.getAccountId()));

        Status status = statusRepository.findById(request.getStatusId())
                .orElseThrow(() -> new IllegalArgumentException("Status not found with ID: " + request.getStatusId()));

        Cart cart = new Cart();
        cart.setCartId(request.getCartId());
        cart.setAccount(account);
        cart.setStatus(status);
        cart.setCartDate(request.getCartDate());

        return cartRepository.save(cart);
    }

    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    public Cart getCartById(String cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found with ID: " + cartId));
    }

    public List<Cart> getCartsByAccountId(Account accountId) {
        return cartRepository.findByAccount_AccountId(accountId);
    }

    public Cart updateCart(String cartId, CartRequest request) {
        Cart cart = getCartById(cartId);

        if (request.getAccountId() != null) {
            Account account = accountRepository.findById(request.getAccountId())
                    .orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + request.getAccountId()));
            cart.setAccount(account);
        }

        if (request.getStatusId() != null) {
            Status status = statusRepository.findById(request.getStatusId())
                    .orElseThrow(() -> new IllegalArgumentException("Status not found with ID: " + request.getStatusId()));
            cart.setStatus(status);
        }

        if (request.getCartDate() != null) {
            cart.setCartDate(request.getCartDate());
        }

        return cartRepository.save(cart);
    }

    public void deleteCart(String cartId) {
        Cart cart = getCartById(cartId);
        cartRepository.delete(cart);
    }

    public void addItemToCart(String cartId, CartItem item) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() ->
                new RuntimeException("Cart not found with id: " + cartId));
        // Thêm logic xử lý sản phẩm
        item.setCartId(cartId);
        cartItemRepository.save(item);
    }

}
