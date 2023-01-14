package com.example.kc.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "contactMessage")
public class ContactMessage {

    @Id
    @SequenceGenerator(name = "seq_message", sequenceName = "seq_message", schema = "kcflowers", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_message")
    @Column(name = "id")
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "active")
    private Boolean active;
}
