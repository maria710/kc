package com.example.kc.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user2")
@Data
public class User2 {

    @Id
    @SequenceGenerator(name = "seq_user", sequenceName = "seq_user", schema = "public", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_user")
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Boolean active;

}
