package com.apoiodigital.main.api.Controllers;

import com.apoiodigital.main.api.Models.Atalho;
import com.apoiodigital.main.api.Models.Requisicao;
import com.apoiodigital.main.api.Services.AtalhoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atalho")
public class AtalhoController {

    private final AtalhoService atalhoService;

    public AtalhoController(AtalhoService atalhoService) {
        this.atalhoService = atalhoService;
    }

    @PostMapping(path = "/criar")
    public ResponseEntity<Atalho> criarAtalho(@RequestParam Requisicao requisicao){
        return ResponseEntity.ok(atalhoService.criarAtalho(requisicao));
    }

    @PostMapping(path = "/iniciar")
    public ResponseEntity<Requisicao> iniciarAtalho(@RequestParam Atalho atalho){
        return ResponseEntity.ok(atalhoService.iniciarAtalho(atalho));
    }
}
