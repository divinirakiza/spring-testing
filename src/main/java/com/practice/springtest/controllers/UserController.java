package com.practice.springtest.controllers;

import com.practice.springtest.domains.APIResponse;
import com.practice.springtest.models.User;
import com.practice.springtest.models.dtos.UserDTO;
import com.practice.springtest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getAll());
    }


    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) {
        User user = this.userService.getById(id);
        if (user == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new APIResponse("User not found"));
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getById(id));
    }

    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        User user = new User(userDTO.getEmail(), userDTO.getFirstName(), userDTO.getFirstName(), userDTO.getType());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.userService.createUser(user));
    }


}
