package com.example.kc.service;

import com.example.kc.dto.UserDTO;
import com.example.kc.entity.User2;
import com.example.kc.mapper.UserMapper;
import com.example.kc.repository.UserRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public void addUser(UserDTO userDTO) {
        User2 user2 = userMapper.toUser(userDTO);
        user2.setActive(true);
        userRepository.save(user2);
    }
}
