// OrderDetailsService.java
package com.AVfood.foodweb.services;

import com.AVfood.foodweb.exceptions.OrderDetailNotFoundException;
import com.AVfood.foodweb.models.OrderDetails;
import com.AVfood.foodweb.models.Product;
import com.AVfood.foodweb.models.Orders;
import com.AVfood.foodweb.repositories.OrderDetailsRepository;
import com.AVfood.foodweb.repositories.ProductRepository;
import com.AVfood.foodweb.repositories.OrdersRepository;
import com.AVfood.foodweb.dtos.request.OrderDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailsService {

    @Autowired
    private OrderDetailsRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrdersRepository ordersRepository;

    public List<OrderDetails> getAllOrderDetails() {
        return repository.findAll();
    }

    public OrderDetails getOrderDetailById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new OrderDetailNotFoundException("Order detail not found with id " + id));
    }

    public OrderDetails createOrderDetail(OrderDetailsRequest dto) {
        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id " + dto.getProductId()));

        Orders order = ordersRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new IllegalArgumentException("Order not found with id " + dto.getOrderId()));

        OrderDetails orderDetail = new OrderDetails(
                dto.getOrderDetailId(),
                product,
                order,
                dto.getOrderQuantity(),
                dto.getOrderTotal()
        );
        return repository.save(orderDetail);
    }

    public OrderDetails updateOrderDetail(String id, OrderDetailsRequest dto) {
        OrderDetails orderDetail = getOrderDetailById(id);
        orderDetail.setOrderQuantity(dto.getOrderQuantity());
        orderDetail.setOrderTotal(dto.getOrderTotal());

        if (!orderDetail.getProduct().getProductId().equals(dto.getProductId())) {
            Product product = productRepository.findById(dto.getProductId())
                    .orElseThrow(() -> new IllegalArgumentException("Product not found with id " + dto.getProductId()));
            orderDetail.setProduct(product);
        }

        if (!orderDetail.getOrder().getOrderId().equals(dto.getOrderId())) {
            Orders order = ordersRepository.findById(dto.getOrderId())
                    .orElseThrow(() -> new IllegalArgumentException("Order not found with id " + dto.getOrderId()));
            orderDetail.setOrder(order);
        }

        return repository.save(orderDetail);
    }

    public void deleteOrderDetail(String id) {
        if (!repository.existsById(id)) {
            throw new OrderDetailNotFoundException("Order detail not found with id " + id);
        }
        repository.deleteById(id);
    }
}
