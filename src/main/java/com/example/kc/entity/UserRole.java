package com.example.kc.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "role")
@Data
public class UserRole {

    @Id
    @SequenceGenerator(name = "seq_role", sequenceName = "seq_role", schema = "public", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_role")
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User2> users2;

}
