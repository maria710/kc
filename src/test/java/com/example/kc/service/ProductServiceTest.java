package com.example.kc.service;

import com.example.kc.dto.ProductDTO;
import com.example.kc.entity.Product;
import com.example.kc.mapper.ProductMapper;
import com.example.kc.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductMapper productMapper;
    @MockBean
    private ProductRepository productRepository;
    private ProductDTO productDTO;
    private Product product;

    @BeforeEach
    public void setUp() {
        productMapper = new ProductMapper();
        productRepository = Mockito.mock(ProductRepository.class);
        productService = new ProductService(productMapper, productRepository);
        productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Sienna");
        productDTO.setDescription("nieco nieco nieco nieco nieco");
        productDTO.setPrice(34.89);
        productDTO.setSale(false);
    }

    @Test
    public void addProductTest() {
        product = productService.addProduct(productDTO);

        assertThat(product.getId()).isEqualTo(1L);
        assertThat(product.getActive()).isTrue();
    }

    @Test void updateProductTest() {

        ProductDTO updatedProduct = new ProductDTO();
        updatedProduct.setId(1L);
        updatedProduct.setName("Vienna");
        updatedProduct.setDescription("nieco nieco nieco nieco nieco");
        updatedProduct.setPrice(60.89);
        updatedProduct.setSale(false);

        Mockito.when(productRepository.existsById(1L)).thenReturn(true);
        product = productService.updateProduct(1L, updatedProduct);
        assertThat(product).isNotNull();
        assertThat(updatedProduct.getName()).isEqualTo("Vienna");

        product = productService.updateProduct(99L, updatedProduct);
        assertThat(product).isNull();
    }

    @Test
    public void deleteProductTest() {
        Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(new Product()));
        product = productService.deleteProduct(1L);

        assertThat(product).isNotNull();
        assertThat(product.getActive()).isFalse();
        Mockito.when(productRepository.findById(2L)).thenReturn(Optional.empty());
        product = productService.deleteProduct(2L);
        assertThat(product).isNull();
    }
}