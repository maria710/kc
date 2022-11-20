package com.example.kc.configuration;

import com.example.kc.mapper.ProductMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfig {

    @Bean
    public ProductMapper productMapper() {return new ProductMapper();}
}
