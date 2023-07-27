package com.example.menu.domain.errors;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super("BAD_REQUEST: " + message);
    }
}
