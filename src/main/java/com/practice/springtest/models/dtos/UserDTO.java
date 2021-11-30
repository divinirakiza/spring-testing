package com.practice.springtest.models.dtos;

import com.practice.springtest.models.User;
import org.springframework.beans.BeanUtils;

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
    public UserDTO(User user){
        BeanUtils.copyProperties(user,this);
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
