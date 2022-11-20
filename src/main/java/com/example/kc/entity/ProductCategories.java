package com.example.kc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "productCategories")
@Data
public class ProductCategories {

    @Id
    @Column(name = "product_id")
    private Long productId;

    @Id
    @Column(name = "subcategory_id")
    private Long subcategoryId;
}
