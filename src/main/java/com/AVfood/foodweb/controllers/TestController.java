package com.AVfood.foodweb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;

@RestController
public class TestController {
    //http://localhost:8081/test-connection
    @Autowired
    private DataSource dataSource;

    @GetMapping("/test-connection")
    public String testConnection() {
        try {
            if (dataSource.getConnection() != null) {
                return "Kết nối đến MySQL thành công!";
            }
        } catch (Exception e) {
            return "Kết nối đến MySQL thất bại: " + e.getMessage();
        }
        return "Kết nối đến MySQL thất bại!";
    }
}
