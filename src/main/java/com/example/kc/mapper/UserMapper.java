package com.example.kc.mapper;


import com.example.kc.dto.UserDTO;
import com.example.kc.entity.User2;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class UserMapper {

    public User2 toUser(UserDTO userDTO) {
        User2 user2 = new User2();
        user2.setId(userDTO.getId());
        user2.setEmail(userDTO.getEmail());
        user2.setPassword(userDTO.getPassword());
        user2.setFirstName(userDTO.getFirstName());
        user2.setLastName(userDTO.getLastName());

        return user2;
    }

    public UserDTO toUserDTO(User2 user2) {
        var userDTO = new UserDTO();
        userDTO.setId(user2.getId());
        userDTO.setEmail(user2.getEmail());
        userDTO.setPassword(user2.getPassword());
        userDTO.setFirstName(user2.getFirstName());
        userDTO.setLastName(user2.getLastName());

        return userDTO;
    }

}
