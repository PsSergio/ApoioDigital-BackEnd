package com.apoiodigital.main.api.exception;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException() {
        super("Credenciais invalidas!");
    }
}
