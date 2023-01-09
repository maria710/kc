package com.example.kc.mapper;

import com.example.kc.dto.CategoryDTO;
import com.example.kc.entity.Category;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CategoryMapper {

    public CategoryDTO toCategoryDTO(Category category) {
        var categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(categoryDTO.getName());
        return categoryDTO;
    }
}
