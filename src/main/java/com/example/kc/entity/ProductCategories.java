package com.example.kc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "productCategories")
@Data
public class ProductCategories {

    @Id
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "subcategory_id")
    private Long subcategoryId;
}
