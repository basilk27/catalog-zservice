package com.mbsystems.catalogservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BookControllerAdvice {

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus( HttpStatus.NOT_FOUND )
    public String bookNotFoundHandler( BookNotFoundException ex ) {
        return ex.getMessage();
    }

    @ExceptionHandler(BookAlreadyExistsException.class)
    @ResponseStatus( HttpStatus.UNPROCESSABLE_ENTITY )
    public String bookAlreadyExistsHandler( BookNotFoundException ex ) {
        return ex.getMessage();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus( HttpStatus.BAD_REQUEST )
    public Map<String, String> handleValidationException( MethodArgumentNotValidException ex ) {
        var errors = new HashMap<String, String>();

        ex.getBindingResult()
                .getAllErrors()
                .forEach( error -> {
                    String fieldName = ((FieldError) error).getField();
                    errors.put(fieldName, error.getDefaultMessage());
                });
        return errors;
    }
}
