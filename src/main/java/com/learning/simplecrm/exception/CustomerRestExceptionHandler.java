package com.learning.simplecrm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerRestExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException exception) {
        CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CustomerErrorResponse> handleException(Exception exception) {
        CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
