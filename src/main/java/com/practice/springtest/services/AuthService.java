package com.practice.springtest.services;

import com.practice.springtest.exceptions.APIRequestException;
import com.practice.springtest.models.User;
import com.practice.springtest.models.dtos.AuthRequestDTO;
import com.practice.springtest.models.dtos.AuthResponseDTO;
import com.practice.springtest.models.dtos.UserDTO;
import com.practice.springtest.repositories.IUserRepository;
import com.practice.springtest.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private JWTUtil jwtUtil;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User userByName = userRepository.findByEmail(usernameOrEmail);

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        if (userByName != null) {
            return new org.springframework.security.core.userdetails.User(userByName.getEmail(), userByName.getPassword(), authorities);
        }else {
            throw new APIRequestException("Wrong Credentials");
        }
    }


    public User getByLogin(String login) {
        return userRepository.findByEmail(login);
    }

    public AuthResponseDTO handleLogin(AuthRequestDTO dto) {
        User user = getByLogin(dto.getLogin());
        if (user == null)
            return null;
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(user.getEmail(), dto.getPassword())
            );
        } catch (Exception ex) {
            return null;
        }
        return new AuthResponseDTO(user.getId(), jwtUtil.generateToken(user));

    }
}
