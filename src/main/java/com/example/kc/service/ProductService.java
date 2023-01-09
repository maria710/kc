package com.example.kc.service;

import com.example.kc.dto.ProductDTO;
import com.example.kc.entity.Product;
import com.example.kc.mapper.ProductMapper;
import com.example.kc.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class ProductService {

    private ProductMapper productMapper;
    private ProductRepository productRepository;

    public Product addProduct(ProductDTO productDTO) {
        var product = productMapper.toProduct(productDTO);
        product.setActive(true);
        productRepository.save(product);
        return product;
    }

    public Product updateProduct(Long id, ProductDTO productDTO) {
        var updatedProduct = new Product();

        if (productRepository.existsById(id)) {
            updatedProduct = productMapper.toProduct(productDTO);
            updatedProduct.setId(id);
            updatedProduct.setActive(true);
            productRepository.save(updatedProduct);
            return updatedProduct;
        }
        return null;
    }

    public Product deleteProduct(Long id) {
        var product = productRepository.findById(id);
        product.ifPresent(p -> p.setActive(false));
        product.ifPresent(productRepository::save);
        return product.orElse(null);
    }

    public List<Product> getProducts() {
        return productRepository.findProductsByActiveTrue();
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
