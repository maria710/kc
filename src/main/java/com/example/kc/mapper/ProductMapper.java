package com.example.kc.mapper;


import com.example.kc.dto.ProductDTO;
import com.example.kc.entity.Product;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductMapper {

    public Product toProduct(ProductDTO productDTO) {
        var product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setSale(productDTO.getSale());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());

        return product;
    }

    public ProductDTO toProductDTO(Product product) {
        var productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setSale(product.getSale());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());

        return productDTO;
    }
}
