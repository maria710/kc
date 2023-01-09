package com.example.kc.dto;

import com.example.kc.entity.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude
public class ProductDTO {

    private Long id;
    private String name;
    private Double price;
    private String description;
    private Boolean sale;
    private Category category;
}
