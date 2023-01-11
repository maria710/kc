package com.example.kc.service;

import com.example.kc.dto.UserDTO;
import com.example.kc.entity.User2;
import com.example.kc.entity.UserRole;
import com.example.kc.mapper.UserMapper;
import com.example.kc.repository.RoleRepository;
import com.example.kc.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@Data
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    public User2 addUser(UserDTO userDTO) {
        User2 user2 = userMapper.toUser(userDTO);
        user2.setActive(true);
        String username = userDTO.getEmail().substring(0,userDTO.getEmail().indexOf("@"));
        user2.setUsername(username);
        user2.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        UserRole userRole = roleRepository.findByName("user");
        user2.setRoles(Collections.singletonList(userRole));
        userRepository.save(user2);
        return user2;
    }

    public boolean userExists(UserDTO userDTO) {
        return userRepository.findUser2ByEmail(userDTO.getEmail()) != null;
    }

    public User2 findByUsername(String username) {
        if (username.contains("@")) {
            username = username.substring(0, username.indexOf("@"));
        }
        return userRepository.findUser2ByUsername(username);
    }
}
