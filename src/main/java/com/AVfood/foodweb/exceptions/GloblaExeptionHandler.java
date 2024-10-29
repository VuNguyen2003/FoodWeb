package com.AVfood.foodweb.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.AVfood.foodweb.models.Account;
import com.AVfood.foodweb.service.AccountService;
import com.AVfood.foodweb.exceptions.AccountExceptions; // Import lớp ngoại lệ chung
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;


@ControllerAdvice
public class GloblaExeptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<String> handlingRuntimeExeption(RuntimeException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(AccountExceptions.AccountAlreadyExistsException.class)
    public ResponseEntity<String> handleAccountAlreadyExists(AccountExceptions.AccountAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(AccountExceptions.AuthenticationFailedException.class)
    public ResponseEntity<String> handleAuthenticationFailed(AccountExceptions.AuthenticationFailedException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    @ExceptionHandler(AccountExceptions.EmailNotFoundException.class)
    public ResponseEntity<String> handleEmailNotFound(AccountExceptions.EmailNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(AccountExceptions.AccountNotFoundException.class)
    public ResponseEntity<String> handleAccountNotFound(AccountExceptions.AccountNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(AccountExceptions.AccountUpdateFailedException.class)
    public ResponseEntity<String> handleAccountUpdateFailed(AccountExceptions.AccountUpdateFailedException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
