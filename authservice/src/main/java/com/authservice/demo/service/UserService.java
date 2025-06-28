package com.authservice.demo.service;

import com.authservice.demo.Model.User;
import com.authservice.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByEmail(String email){
    return userRepository.findByEmail(email);
}
}
