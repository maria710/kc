package com.example.kc.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "product")
@Data
public class Product {

    @Id
    @SequenceGenerator(name = "seq_product", sequenceName = "seq_product", schema = "public", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_product")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "description")
    private String description;

    @Column(name = "in_sale")
    private Boolean sale;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}