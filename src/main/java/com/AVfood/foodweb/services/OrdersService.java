// OrderService.java
package com.AVfood.foodweb.services;

import com.AVfood.foodweb.models.OrderDetails;
import com.AVfood.foodweb.models.Orders;
import com.AVfood.foodweb.models.Product;
import com.AVfood.foodweb.repositories.OrdersRepository;
import com.AVfood.foodweb.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Orders createOrder(String accountId, String paymentMethod, List<Map<String, Object>> items) {
        String orderId = UUID.randomUUID().toString();
        Orders order = new Orders();
        order.setOrderId(orderId);
        order.setAccountId(accountId);
        order.setStatusId("NEW"); // Initial status
        order.setOrderName("Order #" + orderId);

        List<OrderDetails> orderDetailsList = new ArrayList<>();
        BigDecimal totalAmount = BigDecimal.ZERO;

        for (Map<String, Object> item : items) {
            String productId = (String) item.get("productId");
            int quantity = (int) item.get("quantity");

            Optional<Product> optionalProduct = productRepository.findById(productId);
            if (!optionalProduct.isPresent()) {
                throw new RuntimeException("Product not found: " + productId);
            }
            Product product = optionalProduct.get();

            BigDecimal itemTotal = product.getPrice().multiply(BigDecimal.valueOf(quantity));
            totalAmount = totalAmount.add(itemTotal);

            OrderDetails orderDetail = new OrderDetails();
            orderDetail.setOrderDetailId(UUID.randomUUID().toString());
            orderDetail.setOrder(order);
            orderDetail.setProduct(product);
            orderDetail.setOrderQuantity(quantity);
            orderDetail.setOrderTotal(itemTotal);

            orderDetailsList.add(orderDetail);
        }

        order.setOrderDetails(orderDetailsList);
        ordersRepository.save(order);

        return order;
    }

    public List<Orders> getOrderHistory(String accountId) {
        return ordersRepository.findByAccountId(accountId);
    }
}
