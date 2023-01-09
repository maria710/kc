package com.example.kc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude
public class CategoryDTO {

    private Long id;
    private String name;
}
