package com.example.kc.repository;

import com.example.kc.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<UserRole, Long> {

    UserRole findByName(String name);

}
