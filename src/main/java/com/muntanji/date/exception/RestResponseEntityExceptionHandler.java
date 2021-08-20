package com.muntanji.date.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.DateTimeException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {DateTimeException.class, IllegalArgumentException.class})
    protected ResponseEntity<Object> handleExceptions(RuntimeException ex, WebRequest request) {
        String message = ex.getMessage();
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Invalid date , kindly check it", message);
        return new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
