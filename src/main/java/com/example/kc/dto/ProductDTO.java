package com.example.kc.dto;

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
}
