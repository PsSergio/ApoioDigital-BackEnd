package com.apoiodigital.main.api.Controllers;

import com.apoiodigital.main.api.Models.Usuario;
import com.apoiodigital.main.api.Services.UsuarioService;
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
    public ResponseEntity<Void> CriarConta(@RequestBody Usuario usuario) {
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/login")
    public ResponseEntity<Boolean> login(@RequestParam String telefone, @RequestParam String senha) {
        var isValid = usuarioService.validarLogin(senha, telefone);
        var httpStatus = isValid ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(httpStatus).body(isValid);
    }
}
