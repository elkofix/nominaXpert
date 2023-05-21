package com.example.demo1.exceptions;

public class LowSalaryException extends RuntimeException{

    String message;
    public LowSalaryException(String message) {
        super(message);
        this.message = message;
    }
}
