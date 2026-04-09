package com.example.spring_JWToken.dto;

public class RecoveryJwtTokenDto {
    private String token;

    public RecoveryJwtTokenDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
