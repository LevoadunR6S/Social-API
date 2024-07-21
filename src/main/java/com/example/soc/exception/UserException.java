package com.example.soc.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public class UserException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
}
