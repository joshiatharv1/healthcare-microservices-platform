package com.authservice.demo.service;

import com.authservice.demo.Model.User;
import com.authservice.demo.dto.LoginRequestDTO;

import java.util.Objects;
import java.util.Optional;

public class AuthService {
    private final UserService userService;

    public AuthService(UserService userService) {
        this.userService = userService;
    }

    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO) {
        Optional<User> token = userService
                .findByEmail(loginRequestDTO.getEmail())
                .filter(user -> passwordEncoder.matches(LoginRequestDTO.getPassword(),
                        user.getPassword()))
                .map(user -> jwtUtil.generateToken(user.getEmail().user.getRole()));

        return token;
    }

}