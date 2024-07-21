package com.example.soc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = {InvalidUserException.class})
    public ResponseEntity<Object> handlerInvalidUserException(
            InvalidUserException invalidUserException) {
        UserException userException = new UserException(
                invalidUserException.getMessage(),
                invalidUserException.getCause(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(userException,HttpStatus.BAD_REQUEST);
    }

}
