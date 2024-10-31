package com.AVfood.foodweb.services;

import com.AVfood.foodweb.exceptions.CartNotFoundException;
import com.AVfood.foodweb.models.Cart;
import com.AVfood.foodweb.repositories.CartRepository;
import com.AVfood.foodweb.dtos.request.CartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;

    public List<Cart> getAllCarts() {
        return repository.findAll();
    }

    public Cart getCartById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new CartNotFoundException("Cart not found with id " + id));
    }

    public Cart createCart(CartRequest dto) {
        Cart cart = new Cart(
                dto.getCartId(),
                dto.getStatusId(),
                dto.getCartDate()
        );
        return repository.save(cart);
    }

    public Cart updateCart(String id, CartRequest dto) {
        Cart cart = getCartById(id);
        cart.setStatusId(dto.getStatusId());
        cart.setCartDate(dto.getCartDate());
        return repository.save(cart);
    }

    public void deleteCart(String id) {
        if (!repository.existsById(id)) {
            throw new CartNotFoundException("Cart not found with id " + id);
        }
        repository.deleteById(id);
    }
}
