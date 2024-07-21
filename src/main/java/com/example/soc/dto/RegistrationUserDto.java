package com.example.soc.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegistrationUserDto {
    protected String username;
    private String email;
    private String password;
    private String confirmPassword;
    private LocalDate birthDate;
}
