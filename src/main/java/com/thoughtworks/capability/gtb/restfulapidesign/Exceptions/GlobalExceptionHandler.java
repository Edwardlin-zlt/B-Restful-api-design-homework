package com.thoughtworks.capability.gtb.restfulapidesign.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResult handleException(StudentNotExistException exception) {
        return new ErrorResult(exception.getMessage());
    }
}
