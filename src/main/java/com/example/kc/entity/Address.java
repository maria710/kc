package com.example.kc.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "address")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "post_town")
    private String town;

    @Column(name = "post_code")
    private String postcode;

    @Column(name = "street")
    private String street;

    @Column(name = "property_number")
    private String propertyNumber;

    @Column(name = "property_subdivision")
    private String subdivision;

    @Column(name = "county")
    private String county;

    @Column(name = "note")
    private String note;
}
