package com.example.kc.service;

import com.example.kc.dto.CategoryDTO;
import com.example.kc.entity.Category;
import com.example.kc.mapper.CategoryMapper;
import com.example.kc.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryMapper categoryMapper;
    @MockBean
    private CategoryRepository categoryRepository;
    private CategoryDTO categoryDTO;
    private Category category;

    @BeforeEach
    public void setUp() {
        categoryMapper = new CategoryMapper();
        categoryRepository = Mockito.mock(CategoryRepository.class);
        categoryService = new CategoryService(categoryRepository, categoryMapper);
        categoryDTO = new CategoryDTO();
    }

    @Test
    public void findCategotyByNameTest() {
        String name = "christmas";
        category = categoryRepository.findCategoryByName(name);

        assertThat(category).isNotNull();
    }
}