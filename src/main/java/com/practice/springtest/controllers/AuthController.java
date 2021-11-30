package com.practice.springtest.controllers;

import com.practice.springtest.models.dtos.AuthRequestDTO;
import com.practice.springtest.models.dtos.AuthResponseDTO;
import com.practice.springtest.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api")
public class AuthController {

    @Autowired
    private AuthService authenticationService;

    @PostMapping("/auth/login")
    public ResponseEntity<AuthResponseDTO> generateToken(@RequestBody AuthRequestDTO authRequest) {
        if (authenticationService.handleLogin(authRequest) == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(authenticationService.handleLogin(authRequest), HttpStatus.OK);
    }

}
