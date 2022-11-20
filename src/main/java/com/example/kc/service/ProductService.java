package com.example.kc.service;

import com.example.kc.dto.ProductDTO;
import com.example.kc.entity.Product;
import com.example.kc.mapper.ProductMapper;
import com.example.kc.repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;
    private final ProductRepository productRepository;

    public Product addProduct(ProductDTO productDTO) {
        var product = productMapper.toProduct(productDTO);
        product.setActive(true);
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, ProductDTO productDTO) {

        var updatedProduct = productMapper.toProduct(productDTO);

        if (productRepository.existsById(id)) {
            updatedProduct.setId(id);
            updatedProduct.setActive(true);
            productRepository.save(updatedProduct);
            productMapper.toProductDTO(updatedProduct);
        }

        return updatedProduct;
    }

    public Product deleteProduct(Long id) {
        var product = productRepository.findById(id);
        //product.ifPresent(productRepository::delete);
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
