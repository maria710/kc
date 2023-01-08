package com.example.kc.configuration;

import com.example.kc.mapper.ProductMapper;
import com.example.kc.mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public ProductMapper productMapper() {return new ProductMapper();}

    @Bean
    public UserMapper userMapper() {return new UserMapper();}
}
