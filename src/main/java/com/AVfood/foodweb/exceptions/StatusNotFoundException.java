package com.AVfood.foodweb.exceptions;

public class StatusNotFoundException extends RuntimeException {
    public StatusNotFoundException(String message) {
        super(message);
    }
}
