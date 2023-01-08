package com.example.kc.service;

import com.example.kc.dto.UserDTO;
import com.example.kc.entity.User2;
import com.example.kc.entity.UserRole;
import com.example.kc.mapper.UserMapper;
import com.example.kc.repository.RoleRepository;
import com.example.kc.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
@Data
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    public void addUser(UserDTO userDTO) {
        User2 user2 = userMapper.toUser(userDTO);
        user2.setActive(true);
        userRepository.save(user2);

        UserRole userRole = roleRepository.findByName("user");
        user2.setRoles(Collections.singletonList(userRole));
    }

    public boolean userExists(UserDTO userDTO) {
        return userRepository.findUser2ByEmail(userDTO.getEmail()) != null;
    }
}
