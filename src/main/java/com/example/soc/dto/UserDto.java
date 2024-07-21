package com.example.soc.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String username;
    private String email;
    private LocalDate birthDate;
}
