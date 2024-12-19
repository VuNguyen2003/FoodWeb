package com.AVfood.foodweb.exceptions;

public class EmailSendingFailedException extends RuntimeException {
    // Constructor mặc định
    public EmailSendingFailedException() {
        super("Email sending failed.");
    }

    // Constructor có thông điệp chi tiết
    public EmailSendingFailedException(String message) {
        super(message);
    }

    // Constructor với thông điệp và nguyên nhân
    public EmailSendingFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor với nguyên nhân
    public EmailSendingFailedException(Throwable cause) {
        super(cause);
    }
}
