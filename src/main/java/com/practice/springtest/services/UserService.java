package com.practice.springtest.services;

import com.practice.springtest.models.User;
import com.practice.springtest.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;



    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public User getById(Integer id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        return optionalUser.orElse(null);
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }

}
