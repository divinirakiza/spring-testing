package com.practice.springtest.models.dtos;

public class UserDTO {
    private String email;

    private String firstName;

    private String lastName;

    private String type;

    public UserDTO(String email, String firstName, String lastName, String type) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getType() {
        return type;
    }
}
