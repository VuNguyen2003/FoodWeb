package com.AVfood.foodweb.service;

import com.AVfood.foodweb.reponsitorys.CartItemReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
    @Autowired
    private CartItemReponsitory cartItemReponsitory;
}
