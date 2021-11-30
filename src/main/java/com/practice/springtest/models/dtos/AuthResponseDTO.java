package com.practice.springtest.models.dtos;

public class AuthResponseDTO {
    private String token;
    private Integer userId;

    public String getToken() {
        return token;
    }

    public Integer getUserId() {
        return userId;
    }

    public AuthResponseDTO(Integer userId, String token) {
        this.token = token;
        this.userId = userId;
    }
}
