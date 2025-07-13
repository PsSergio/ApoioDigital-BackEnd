package com.apoiodigital.main.api.Controllers;

import com.apoiodigital.main.api.Models.Usuario;
import com.apoiodigital.main.api.Services.AtalhoService;
import com.apoiodigital.main.api.Services.RequisicaoService;
import com.apoiodigital.main.api.Services.UsuarioService;
import com.apoiodigital.main.api.exception.InvalidCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final RequisicaoService requisicaoService;
    private final AtalhoService atalhoService;

    public UsuarioController(UsuarioService usuarioService, RequisicaoService requisicaoService, AtalhoService atalhoService) {
        this.usuarioService = usuarioService;
        this.requisicaoService = requisicaoService;
        this.atalhoService = atalhoService;
    }

    @PostMapping("/salvar")
    public ResponseEntity<Usuario> criarConta(@RequestBody Usuario usuario) {
        var usuarioDB = usuarioService.salvarUsuario(usuario);
        var requisicoesIniciais = requisicaoService.salvarRequisicoesIniciais(usuario.getId());
        atalhoService.salvarAtalhosIniciais(requisicoesIniciais);
        return ResponseEntity.ok().body(usuarioDB);
    }

    @GetMapping("/login")
    public ResponseEntity<Boolean> login(@RequestParam String telefone, @RequestParam String senha) {
        var isValid = usuarioService.validarLogin(senha, telefone);

        if(!isValid) throw new InvalidCredentialsException();

        return ResponseEntity.status(HttpStatus.OK).body(true);
    }
}
