package com.apoiodigital.main.api.Controllers;

import com.apoiodigital.main.api.Models.Atalho;
import com.apoiodigital.main.api.Models.Requisicao;
import com.apoiodigital.main.api.Models.Usuario;
import com.apoiodigital.main.api.Services.AtalhoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/atalho")
public class AtalhoController {

    private final AtalhoService atalhoService;

    public AtalhoController(AtalhoService atalhoService) {
        this.atalhoService = atalhoService;
    }

    @PostMapping(path = "/criar")
    public ResponseEntity<Atalho> criarAtalho(@RequestParam UUID id_requisicao){
        return ResponseEntity.ok(atalhoService.criarAtalho(id_requisicao));
    }

    @PostMapping(path = "/iniciar")
    public ResponseEntity<Requisicao> iniciarAtalho(@RequestParam UUID id_atalho){
        return ResponseEntity.ok(atalhoService.iniciarAtalho(id_atalho));
    }

    @GetMapping(path = "/carregar")
    public ResponseEntity<List<Atalho>> carregarAtalhos(@RequestParam UUID id_usuario){
        return ResponseEntity.ok(atalhoService.carregarAtalhos(id_usuario));
    }
}
