package com.example.kc.repository;

import com.example.kc.entity.Category;
import com.example.kc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductsByActiveTrue();
    List<Product> findProductsByCategoryNameAndActiveTrue(String name);
    List<Product> findProductsBySaleTrueAndActiveTrue();
}
