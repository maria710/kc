package com.example.kc.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude
public class ContactMessageDTO {

    private Long id;
    private String message;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean active;
}
