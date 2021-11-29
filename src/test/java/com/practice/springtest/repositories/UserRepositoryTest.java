package com.practice.springtest.repositories;

import com.practice.springtest.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private IUserRepository userRepository;

    @Test
    public void getAll_Success() {
        List<User> users = this.userRepository.findAll();
        assertEquals(1, users.size());
    }

    @Test
    public void getById_Success() {
        Optional<User> optionalUser = this.userRepository.findById(1);
        assertTrue(optionalUser.isPresent());
    }

    @Test
    public void getById_NotFound() {
        Optional<User> optionalUser = this.userRepository.findById(4);
        assertFalse(optionalUser.isPresent());
    }
}
