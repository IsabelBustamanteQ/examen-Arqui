package com.example.proyecto.dto;

public class LoginResponseDto {
    private String token;
    private String timestamp;
    public LoginResponseDto(String token, String timestamp) {
        this.token = token;
        this.timestamp = timestamp;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
