package com.apoiodigital.main.api.Controllers;

import com.apoiodigital.main.api.Models.Usuario;
import com.apoiodigital.main.api.Services.UsuarioService;
import com.apoiodigital.main.api.exception.InvalidCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/salvar")
    public ResponseEntity<Usuario> criarConta(@RequestBody Usuario usuario) {
        return ResponseEntity.ok().body(usuarioService.salvarUsuario(usuario));
    }

    @GetMapping("/login")
    public ResponseEntity<Boolean> login(@RequestParam String telefone, @RequestParam String senha) {
        var isValid = usuarioService.validarLogin(senha, telefone);

        if(!isValid) throw new InvalidCredentialsException();

        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
}
