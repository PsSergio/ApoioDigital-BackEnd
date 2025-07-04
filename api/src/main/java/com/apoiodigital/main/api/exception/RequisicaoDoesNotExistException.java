package com.apoiodigital.main.api.exception;

public class RequisicaoDoesNotExistException extends RuntimeException {
    public RequisicaoDoesNotExistException() {
        super("Requisicao nao encontrada");
    }
}
