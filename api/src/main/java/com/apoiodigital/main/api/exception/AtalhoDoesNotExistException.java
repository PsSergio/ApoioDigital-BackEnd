package com.apoiodigital.main.api.exception;

public class AtalhoDoesNotExistException extends RuntimeException {
    public AtalhoDoesNotExistException() {
        super("Atalho nao encontrado");
    }
}
