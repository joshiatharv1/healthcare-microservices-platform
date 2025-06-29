package com.authservice.demo.service;

import com.authservice.demo.Model.User;
import com.authservice.demo.dto.LoginRequestDTO;
import com.authservice.demo.util.JwtUtil;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    public AuthService(UserService userService, PasswordEncoder passwordEncoder, JwtUtil jwtUtil)
    {
        this.userService = userService;
        this.passwordEncoder=passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public Optional<String> authenticate(LoginRequestDTO loginRequestDTO) {
        Optional<User> userOpt = userService.findByEmail(loginRequestDTO.getEmail());

        if (userOpt.isEmpty()) {
            System.out.println("User not found for email: " + loginRequestDTO.getEmail());
            return Optional.empty();
        }

        User user = userOpt.get();
        System.out.println("User found: " + user.getEmail());

        boolean match = passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword());
        System.out.println("Password match: " + match);

        if (!match) {
            return Optional.empty();
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
        System.out.println("Generated token: " + token);

        return Optional.of(token);
    }

    public boolean validateToken(String token) {
        try{
            jwtUtil.validateToken(token);
            return true;
        }catch (JwtException ex){
            return false;
        }
    }
}