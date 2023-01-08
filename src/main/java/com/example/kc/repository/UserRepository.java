package com.example.kc.repository;

import com.example.kc.entity.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User2, Long> {

    User2 findUser2ByEmail(String email);
}
