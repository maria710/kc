package com.example.kc.configuration;

import com.example.kc.mapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class ProductConfig {

    @Bean
    public ProductMapper productMapper() {
        return new ProductMapper();
    }

    @Bean
    public UserMapper userMapper() {
        return new UserMapper();
    }

    @Bean
    public CategoryMapper categoryMapper() {
        return new CategoryMapper();
    }

    @Bean
    public ContactMessageMapper contactMessageMapper() {
        return new ContactMessageMapper();
    }

    @Bean
    public CartItemMapper cartItemMapper() {
        return new CartItemMapper();
    }

}
