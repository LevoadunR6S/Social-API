package com.example.soc.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> responseBuilder
            (HttpStatus httpStatus, Object responseObject, String name)
    {
        Map<String, Object> response = new HashMap<>();
        response.put("httpStatus", httpStatus);
        response.put(name,responseObject);
        return new ResponseEntity<>(response,httpStatus);
    }
}
