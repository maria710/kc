package com.example.kc.service;

import com.example.kc.dto.CategoryDTO;
import com.example.kc.mapper.CategoryMapper;
import com.example.kc.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryDTO findCategoryByName(String name) {
        name = name.toLowerCase();
        var category = categoryRepository.findCategoryByName(name);
        if (category != null) {
            return categoryMapper.toCategoryDTO(category);
        }
        return null;
    }
}
