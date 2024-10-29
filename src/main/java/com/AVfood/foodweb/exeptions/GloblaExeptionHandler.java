package com.AVfood.foodweb.exeptions;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GloblaExeptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<String> handlingRuntimeExeption(RuntimeException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
