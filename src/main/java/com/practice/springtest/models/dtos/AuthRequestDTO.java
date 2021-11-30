package com.practice.springtest.models.dtos;

public class AuthRequestDTO {
    private String login;
    private String password;


    public AuthRequestDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }


    public String getPassword() {
        return password;
    }

}
