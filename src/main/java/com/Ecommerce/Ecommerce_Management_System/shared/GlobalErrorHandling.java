package com.Ecommerce.Ecommerce_Management_System.shared;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.List;

@ControllerAdvice
public class GlobalErrorHandling {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<GlobalResponse<?>> noResourceHandler(NoResourceFoundException exception) {
        var error = List.of(new GlobalResponse.ErrorItems("Resource Not Found"));
        return new ResponseEntity<>(new GlobalResponse<GlobalResponse.ErrorItems>(error), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GlobalResponse<?>> ValidationHanlder(MethodArgumentNotValidException exception) {
        List<GlobalResponse.ErrorItems> error = exception.getBindingResult().getFieldErrors()
                .stream().map(err ->
                        new GlobalResponse.ErrorItems(err.getField() + " " + err.getDefaultMessage())).toList();
        return new ResponseEntity<>(new GlobalResponse<>(error), HttpStatus.BAD_REQUEST);
    }
}
