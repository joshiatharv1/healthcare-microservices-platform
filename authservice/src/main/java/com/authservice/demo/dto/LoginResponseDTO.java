package com.authservice.demo.dto;

import org.apache.logging.log4j.message.StringFormattedMessage;

public class LoginResponseDTO {
    private String token;
    public LoginResponseDTO(String token){
        this.token=token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
