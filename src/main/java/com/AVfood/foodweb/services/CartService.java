package com.AVfood.foodweb.services;

import com.AVfood.foodweb.dto.CartRequest;
import com.AVfood.foodweb.models.Account;
import com.AVfood.foodweb.models.Cart;
import com.AVfood.foodweb.models.Status;
import com.AVfood.foodweb.repositories.AccountRepository;
import com.AVfood.foodweb.repositories.CartRepository;
import com.AVfood.foodweb.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private StatusRepository statusRepository;

    /**
     * Tạo một Cart mới dựa trên CartRequest DTO
     *
     * @param dto Dữ liệu từ client để tạo Cart
     * @return Cart đã được lưu vào cơ sở dữ liệu
     * @throws IllegalArgumentException nếu Account hoặc Status không tồn tại
     */
    public Cart createCart(CartRequest dto) {
        // Kiểm tra và lấy Account
        Optional<Account> accountOpt = accountRepository.findById(dto.getAccountId());
        if (!accountOpt.isPresent()) {
            throw new IllegalArgumentException("Account not found with ID: " + dto.getAccountId());
        }
        Account account = accountOpt.get();

        // Kiểm tra và lấy Status
        Optional<Status> statusOpt = statusRepository.findById(dto.getStatusId());
        if (!statusOpt.isPresent()) {
            throw new IllegalArgumentException("Status not found with ID: " + dto.getStatusId());
        }
        Status status = statusOpt.get();

        // Tạo Cart mới
        Cart cart = new Cart(
                dto.getCartId(),
                account,
                status,
                dto.getCartDate()
        );

        return cartRepository.save(cart);
    }

    /**
     * Lấy tất cả các Cart
     *
     * @return Danh sách tất cả các Cart
     */
    public List<Cart> getAllCarts() {
        return cartRepository.findAll();
    }

    /**
     * Lấy Cart theo ID
     *
     * @param cartId ID của Cart
     * @return Cart nếu tồn tại
     * @throws IllegalArgumentException nếu Cart không tồn tại
     */
    public Cart getCartById(String cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new IllegalArgumentException("Cart not found with ID: " + cartId));
    }

    /**
     * Cập nhật một Cart
     *
     * @param cartId ID của Cart cần cập nhật
     * @param dto    Dữ liệu cập nhật từ client
     * @return Cart đã được cập nhật
     */
    public Cart updateCart(String cartId, CartRequest dto) {
        Cart existingCart = getCartById(cartId);

        // Cập nhật các trường cần thiết
        if (dto.getAccountId() != null) {
            Account account = accountRepository.findById(dto.getAccountId())
                    .orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + dto.getAccountId()));
            existingCart.setAccount(account);
        }

        if (dto.getStatusId() != null) {
            Status status = statusRepository.findById(dto.getStatusId())
                    .orElseThrow(() -> new IllegalArgumentException("Status not found with ID: " + dto.getStatusId()));
            existingCart.setStatus(status);
        }

        if (dto.getCartDate() != null) {
            existingCart.setCartDate(dto.getCartDate());
        }

        return cartRepository.save(existingCart);
    }

    /**
     * Xóa một Cart
     *
     * @param cartId ID của Cart cần xóa
     */
    public void deleteCart(String cartId) {
        Cart existingCart = getCartById(cartId);
        cartRepository.delete(existingCart);
    }
}
