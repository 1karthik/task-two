package com.test.tasktwo.exception;

public class ColorNotFoundException extends RuntimeException {
    public ColorNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}