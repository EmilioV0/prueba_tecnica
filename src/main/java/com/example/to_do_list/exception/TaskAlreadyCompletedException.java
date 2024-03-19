package com.example.to_do_list.exception;

import org.springframework.http.HttpStatus;

public class TaskAlreadyCompletedException extends CustomException {
    public TaskAlreadyCompletedException(String className, int id, HttpStatus statusCode) {
        super("Resource " + className + " with id " + id + " already completed", statusCode);
    }
}
