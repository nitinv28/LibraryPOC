package com.genpect.libraries.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ErrorHandlingController {
	
	
	@ExceptionHandler(CustomException.class)
    public final ResponseEntity<Error> handleCustomException(CustomException ex) {
        Error error = new Error();
        error.setDescription(ex.getDescription());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@ExceptionHandler(Exception.class)
    public final ResponseEntity<Error> handleAllExceptions(Exception ex) {
        Error error = new Error();
        error.setDescription(ex.getLocalizedMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
