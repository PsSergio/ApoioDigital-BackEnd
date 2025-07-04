package com.apoiodigital.main.api.handler;

import com.apoiodigital.main.api.Dtos.ExceptionDTO;
import com.apoiodigital.main.api.exception.InvalidCredentialsException;
import com.apoiodigital.main.api.exception.InvalidPasswordLengthException;
import com.apoiodigital.main.api.exception.TelefoneAlreayExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestHandlerExceptions {

//  USUARIO ----------------------------------------------
    @ExceptionHandler(InvalidPasswordLengthException.class)
    public ResponseEntity<ExceptionDTO> InvalidPasswordLengthHandler(InvalidPasswordLengthException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(HttpStatus.BAD_REQUEST.value(), "InvalidPasswordLength", ex.getMessage()));
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ExceptionDTO> InvalidCredentialsHandler(InvalidCredentialsException ex) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ExceptionDTO(HttpStatus.UNAUTHORIZED.value(), "InvalidCredentials", ex.getMessage()));
    }

    @ExceptionHandler(TelefoneAlreayExistsException.class)
    public ResponseEntity<ExceptionDTO> TelefoneAlreadyExistsHandler(TelefoneAlreayExistsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(HttpStatus.BAD_REQUEST.value(), "TelefoneAlreadyExists", ex.getMessage()));
    }
}
