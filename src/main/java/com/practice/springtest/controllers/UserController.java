package com.practice.springtest.controllers;

import com.practice.springtest.models.User;
import com.practice.springtest.models.dtos.UserDTO;
import com.practice.springtest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getAll());
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getById(id));
    }

    @GetMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        User user = new User(userDTO.getEmail(), userDTO.getFirstName(), userDTO.getFirstName(), userDTO.getType());
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.createUser(user));
    }


}