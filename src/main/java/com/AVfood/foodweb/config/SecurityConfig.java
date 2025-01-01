package com.AVfood.foodweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


import java.util.Set;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // Cho phép cookie hoặc xác thực
        config.addAllowedOriginPattern("http://localhost:3000"); // Frontend URL
        config.addAllowedHeader("*"); // Cho phép tất cả các header
        config.addAllowedMethod("*"); // Cho phép tất cả các phương thức HTTP

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Đăng ký cấu hình CORS cho tất cả các endpoint
        return new CorsFilter(source);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers(getPublicEndpoints().toArray(new String[0])) // CSRF không áp dụng với endpoint công khai
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(getPublicEndpoints().toArray(new String[0])).permitAll() // Endpoint công khai
                        .requestMatchers("/api/admin/**").hasRole("ADMIN") // Chỉ ADMIN mới truy cập được các endpoint này
                        .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN") // USER và ADMIN đều có thể truy cập
                        .anyRequest().authenticated() // Các yêu cầu còn lại cần xác thực
                )
                .formLogin(form -> form
                        .loginPage("/login") // Định nghĩa trang đăng nhập tùy chỉnh
                        .defaultSuccessUrl("/home", true) // Chuyển đến trang chủ sau khi đăng nhập thành công
                        .permitAll() // Ai cũng có thể truy cập trang đăng nhập
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Định nghĩa URL để đăng xuất
                        .logoutSuccessUrl("/login?logout") // Chuyển đến trang đăng nhập sau khi đăng xuất thành công
                        .permitAll() // Ai cũng có thể truy cập logout
                );

        return http.build();
    }

    // Phương thức để lấy danh sách các endpoint công khai
    private Set<String> getPublicEndpoints() {
        return Set.of(
                "/api/v1/account/*",
                "/api/v1/cartitem/*",
                "/api/v1/products/**",
                "/api/v1/products/{id}",
                "/api/v1/products",
                "/test-connection",
                "/public/**" // Bổ sung thêm các endpoint không yêu cầu xác thực
        );
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Mã hóa mật khẩu người dùng
    }
}
