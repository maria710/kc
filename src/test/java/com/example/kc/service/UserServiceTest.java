package com.example.kc.service;

import com.example.kc.dto.UserDTO;
import com.example.kc.entity.User2;
import com.example.kc.mapper.UserMapper;
import com.example.kc.repository.RoleRepository;
import com.example.kc.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;
    @InjectMocks
    private UserService userService;
    @Mock
    private UserMapper userMapper;

    @Mock
    private PasswordEncoder passwordEncoder;

    private User2 user2;
    private User2 savedUser2;
    private UserDTO userDTO;

    @BeforeEach
    public void setUp() {
        userMapper = new UserMapper();
        passwordEncoder = Mockito.mock(PasswordEncoder.class);
        userRepository = Mockito.mock(UserRepository.class);
        roleRepository = Mockito.mock(RoleRepository.class);
        userService = new UserService(userRepository, roleRepository, userMapper, passwordEncoder);
        user2 = new User2();
        user2.setId(1L);
        user2.setFirstName("Maria");
        user2.setLastName("kuruczova");
        user2.setEmail("mk@gmail.sk");
        user2.setPassword("2343453");

        savedUser2 = new User2();
        userDTO = new UserDTO();
    }

    @Test
    public void addUserTest() {

        userDTO = userMapper.toUserDTO(user2);
        savedUser2 = userService.addUser(userDTO);

        assertThat(savedUser2.getActive()).isTrue();
        assertThat(savedUser2.getRoles()).isNotNull();
    }
}