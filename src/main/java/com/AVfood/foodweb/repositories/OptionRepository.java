package com.AVfood.foodweb.repositories;

import com.AVfood.foodweb.models.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionRepository extends JpaRepository<Option, String> {
    List<Option> findByOptionCategoryId(String optionCategoryId);
}

