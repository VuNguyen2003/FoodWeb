package com.AVfood.foodweb.exceptions;

public class AccountExceptions {

    public static class AccountAlreadyExistsException extends RuntimeException {
        public AccountAlreadyExistsException(String message) {
            super(message);
        }
    }

    public static class AuthenticationFailedException extends RuntimeException {
        public AuthenticationFailedException(String message) {
            super(message);
        }
    }

    public static class EmailNotFoundException extends RuntimeException {
        public EmailNotFoundException(String message) {
            super(message);
        }
    }

    public static class AccountNotFoundException extends RuntimeException {
        public AccountNotFoundException(String message) {
            super(message);
        }
    }

    public static class AccountUpdateFailedException extends RuntimeException {
        public AccountUpdateFailedException(String message) {
            super(message);
        }
    }
}
