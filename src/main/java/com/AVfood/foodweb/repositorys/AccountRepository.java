package com.AVfood.foodweb.repositorys;

import com.AVfood.foodweb.models.Account;
import com.AVfood.foodweb.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
