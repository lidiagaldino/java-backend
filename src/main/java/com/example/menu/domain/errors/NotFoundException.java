package com.example.menu.domain.errors;

public class NotFoundException extends RuntimeException{
    public NotFoundException(){
        super("NOT_FOUND");
    }
}
