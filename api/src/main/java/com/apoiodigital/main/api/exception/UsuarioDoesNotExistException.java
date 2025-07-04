package com.apoiodigital.main.api.exception;

public class UsuarioDoesNotExistException extends RuntimeException {
    public UsuarioDoesNotExistException() {
        super("Usuario nao encontrado!");
    }
}
