package com.example.kc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
