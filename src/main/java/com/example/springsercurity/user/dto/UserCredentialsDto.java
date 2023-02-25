package com.example.springsercurity.user.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Set;


@Data
@RequiredArgsConstructor
public class UserCredentialsDto {

    private final String email;
    private final String password;
    private final Set<String> roles;

}
