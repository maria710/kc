package com.example.kc.dto;

import com.example.kc.entity.Product;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude
public class CartItemDTO {
    private Long id;
    private Product product;
    private Integer quantity;
}
