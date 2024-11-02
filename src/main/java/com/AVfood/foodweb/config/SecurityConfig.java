package com.AVfood.foodweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

import java.util.Set;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(getPublicEndpoints().toArray(new String[0])) // Chuyển đổi Set<String> thành String[]
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(getPublicEndpoints().toArray(new String[0])).permitAll() // Cho phép tất cả các endpoint này mà không cần xác thực
                        .anyRequest().authenticated() // Tất cả các yêu cầu khác cần xác thực
                )
                .httpBasic(Customizer.withDefaults()); // Hoặc sử dụng formLogin() nếu cần

        return http.build();
    }

    // Phương thức để lấy danh sách các endpoint công khai
    private Set<String> getPublicEndpoints() {
        return Set.of(
                "/api/v1/cartitem/getallitems",
                "/test-connection",
                "/api/v1/products"
                // Thêm các endpoint khác ở đây
        );
    }


    // Phương thức để lấy danh sách các endpoint công khai


    @Bean // Đánh dấu phương thức này để tạo một bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Trả về một instance của BCryptPasswordEncoder
    }
}
