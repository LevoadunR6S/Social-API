package com.example.soc.controller;

import com.example.soc.dto.JwtRequest;
import com.example.soc.dto.RegistrationUserDto;
import com.example.soc.response.ResponseHandler;
import com.example.soc.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @GetMapping("/signup")
    public ResponseEntity<?> getCreatedUser() {
        return ResponseHandler.responseBuilder(HttpStatus.OK, "You can create new user here", "info");
    }


    @PostMapping("/signup")
    public ResponseEntity<?> createNewUser(@RequestBody RegistrationUserDto registrationUserDto) {
        return authService.createNewUser(registrationUserDto);
    }



    @PostMapping("/auth")
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }
}
