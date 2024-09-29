package com.starksecurity.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {

    // Getters y Setters
    private String email;
    private String password;

}