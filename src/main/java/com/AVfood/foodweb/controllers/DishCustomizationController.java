package com.AVfood.foodweb.controllers;

import com.AVfood.foodweb.models.Option;
import com.AVfood.foodweb.models.ProductOption;
import com.AVfood.foodweb.services.OptionService;
import com.AVfood.foodweb.services.ProductOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dishes")
public class DishCustomizationController {

    @Autowired
    private ProductOptionService productOptionService;

    @Autowired
    private OptionService optionService;

    @PostMapping("/{productId}/customize")
    public ResponseEntity<?> customizeDish(@PathVariable String productId, @RequestBody List<String> selectedOptionIds) {
        if (selectedOptionIds == null || selectedOptionIds.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of(
                    "error", "No options selected",
                    "message", "Please select at least one option to customize the dish."
            ));
        }

        // Lấy tất cả tùy chọn hợp lệ cho món ăn
        List<ProductOption> productOptions = productOptionService.getProductOptions(productId);
        if (productOptions.isEmpty()) {
            return ResponseEntity.badRequest().body(Map.of(
                    "error", "No valid options found",
                    "message", "The product does not have any customizable options."
            ));
        }

        // Tìm các Option hợp lệ từ danh sách chọn
        List<Option> selectedOptions = new ArrayList<>();
        for (String optionId : selectedOptionIds) {
            boolean isValidOption = productOptions.stream()
                    .map(ProductOption::getOptionCategory)
                    .flatMap(category -> category.getOptions().stream())
                    .anyMatch(option -> option.getOptionId().equals(optionId));

            if (!isValidOption) {
                return ResponseEntity.badRequest().body(Map.of(
                        "error", "Invalid Option ID",
                        "message", "The option ID " + optionId + " is not valid for this product."
                ));
            }

            // Lấy tùy chọn
            Option option = optionService.getOptionById(optionId)
                    .orElseThrow(() -> new RuntimeException("Option not found: " + optionId));
            selectedOptions.add(option);
        }

        // Tính giá món ăn sau khi thêm các tùy chọn
        double totalAdditionalPrice = selectedOptions.stream()
                .mapToDouble(Option::getAdditionalPrice)
                .sum();

        return ResponseEntity.ok(Map.of(
                "productId", productId,
                "selectedOptions", selectedOptions,
                "totalAdditionalPrice", totalAdditionalPrice
        ));
    }
}
