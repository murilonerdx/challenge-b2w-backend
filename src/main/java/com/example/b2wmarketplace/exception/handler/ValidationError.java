package com.example.b2wmarketplace.exception.handler;

import com.example.b2wmarketplace.exception.BadParamException;
import com.example.b2wmarketplace.exception.FieldErrorValidation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ValidationError {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(code= HttpStatus.BAD_REQUEST)
    public List<FieldErrorValidation> handle(MethodArgumentNotValidException e){
        List<FieldErrorValidation> fieldErrorValidation = new ArrayList<>();
        List<FieldError> errors = e.getBindingResult().getFieldErrors();
        errors.forEach(error->{
            fieldErrorValidation.add(new FieldErrorValidation(error.getField(), error.getDefaultMessage()));
        });
        return fieldErrorValidation;
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<FieldErrorValidation> handleAllExceptions(Exception ex, WebRequest request) {
        FieldErrorValidation exceptionResponse =
                new FieldErrorValidation(
                        ex.getMessage(),
                        request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadParamException.class)
    public final ResponseEntity<FieldErrorValidation> handleBadRequestExceptions(Exception ex, WebRequest request) {
        FieldErrorValidation exceptionResponse =
                new FieldErrorValidation(
                        ex.getMessage(),
                        request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
