package com.example.kc.configuration;

import com.example.kc.mapper.CategoryMapper;
import com.example.kc.mapper.ProductMapper;
import com.example.kc.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

@Configuration
public class ProductConfig {

    @Bean
    public ProductMapper productMapper() {return new ProductMapper();}

    @Bean
    public UserMapper userMapper() {return new UserMapper();}
    @Bean
    public CategoryMapper categoryMapper() {return new CategoryMapper();}

}
