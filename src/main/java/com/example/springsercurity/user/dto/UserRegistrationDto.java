package com.example.springsercurity.user.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {

    private String email;
    private String password;
    private String firstName;
    private String lastName;

}
