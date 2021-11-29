package com.practice.springtest.services;

import com.practice.springtest.models.User;
import com.practice.springtest.repositories.IUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private IUserRepository userRepositoryMock;

    @InjectMocks
    private UserService userService;


    @Test
    public void getAll_withData() {
        when(userRepositoryMock.findAll())
                .thenReturn(
                        Collections.singletonList(
                                new User(1, "user1@email.ed", "User", "two", "ADMIN")
                        )
                );
        assertEquals(1, userService.getAll().get(0).getId());
    }

    @Test
    public void getById_Success() {
        User user = new User(1, "user1@email.ed", "User", "two", "ADMIN");

        when(userRepositoryMock.findById(1)).thenReturn(Optional.of(user));

        assertEquals(1, userService.getById(1).getId());
    }

    @Test
    public void getById_UserNotFound() {
        User user = new User(1, "user1@email.ed", "User", "two", "ADMIN");

        when(userRepositoryMock.findById(1)).thenReturn(Optional.of(user));

        assertNull(userService.getById(3));
    }

    @Test
    public void createUser_Success() {
        User user = new User(1, "user1@email.ed", "User", "two", "ADMIN");

        when(userRepositoryMock.save(user)).thenReturn(user);

        assertEquals(user.getId(), this.userService.createUser(user).getId());
    }

}

