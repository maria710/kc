package com.example.kc.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @SequenceGenerator(name = "seq_user", sequenceName = "seq_user", schema = "kcflowers", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    @Column(name = "id")
    private Long id;

    @Column(name = "person_id")
    private String personId;

    @Column(name = "email")
    private Long email;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private String active;

}
