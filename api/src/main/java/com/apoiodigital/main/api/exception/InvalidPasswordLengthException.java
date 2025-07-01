package com.apoiodigital.main.api.exception;

public class InvalidPasswordLengthException extends RuntimeException {
    public InvalidPasswordLengthException() {
        super("A senha deve ter no minimo 8 caracteres!");
    }
}
