package com.authservice.demo.controller;

import com.authservice.demo.dto.LoginRequestDTO;
import com.authservice.demo.dto.LoginResponseDTO;
import com.authservice.demo.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.GeneratedValue;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.remote.JMXAuthenticator;
import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Operation(summary = "Generate token for user")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {

        Optional<String> tokenOptional = authService.authenticate(loginRequestDTO);
        if (tokenOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        String token = tokenOptional.get();
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @Operation(summary = "Validate Token")
    @GetMapping("/validate")
    public ResponseEntity<Void> validateToken(@RequestHeader("Authorization")
                                                  String authHeader){
        if(authHeader==null || !authHeader.startsWith("Bearer ")){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return authService.validateToken(authHeader.substring(7))
                ? ResponseEntity.ok().build()
                : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    }

