package com.practice.springtest.services;


import com.practice.springtest.models.User;
import com.practice.springtest.models.dtos.AuthRequestDTO;
import com.practice.springtest.models.dtos.AuthResponseDTO;
import com.practice.springtest.models.dtos.UserDTO;
import com.practice.springtest.repositories.IUserRepository;
import com.practice.springtest.utils.JWTUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthServiceTest {
    @Mock
    private IUserRepository userRepositoryMock;


    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private JWTUtil jwtUtil;

    @InjectMocks
    private AuthService authService;


    @Test
    public void login_Success() {
        AuthRequestDTO dto = new AuthRequestDTO("email@test.e", "123");
        User user = new User(1, "email@test.e", "Auth", "Tester", "123");

        when(userRepositoryMock.findByEmail(dto.getLogin())).thenReturn(user);

        System.out.println(new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getPassword()));
        when(authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getPassword())
        )).thenReturn(null);

        AuthResponseDTO responseDTO = new AuthResponseDTO(1, "Token");
        when(jwtUtil.generateToken(user)).thenReturn(String.valueOf(responseDTO.getToken()));

        assertEquals(String.valueOf(new AuthResponseDTO(1, "Token").getToken()), String.valueOf(authService.handleLogin(dto).getToken()));
    }

    @Test
    public void login_Failed() {
        AuthRequestDTO dto = new AuthRequestDTO("end@jdsa", "123");

        when(userRepositoryMock.findByEmail(dto.getLogin())).thenReturn(null);

        assertNull(authService.handleLogin(dto));
    }
}
