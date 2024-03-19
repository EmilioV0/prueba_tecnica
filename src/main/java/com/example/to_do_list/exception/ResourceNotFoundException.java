package com.example.to_do_list.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends CustomException {
    public ResourceNotFoundException(String className, int id, HttpStatus statusCode) {
        super("Resource " + className + " with id " + id + " not found.", statusCode);
    }
}
