package com.example.kc.entity;

import javax.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "category")
@Data
public class Category {

    @Id
    @SequenceGenerator(name = "seq_category", sequenceName = "seq_category", schema = "kcflowers", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_category")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
