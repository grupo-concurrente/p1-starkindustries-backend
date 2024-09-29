package com.starksecurity.backend.dto;

import lombok.Getter;

@Getter
public class LoginRequest {

    // Getters y Setters
    private String email;
    private String password;

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}