package com.apoiodigital.main.api.exception;

public class TelefoneAlreayExistsException extends RuntimeException {
    public TelefoneAlreayExistsException() {
        super("Este telefone ja esta cadastrado!");
    }
}
