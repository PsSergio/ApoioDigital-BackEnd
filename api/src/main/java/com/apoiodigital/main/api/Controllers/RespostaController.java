package com.apoiodigital.main.api.Controllers;

import com.apoiodigital.main.api.Models.Requisicao;
import com.apoiodigital.main.api.Models.Resposta;
import com.apoiodigital.main.api.Services.RespostaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resposta/")
public class RespostaController {

    private final RespostaService respostaService;

    public RespostaController(RespostaService respostaService) {
        this.respostaService = respostaService;
    }

    @PostMapping("/exigir")
    public ResponseEntity<Resposta> ExigirRespostaDaIA(@RequestParam Requisicao requisicao){
        return ResponseEntity.ok().body(respostaService.salvarResposta(requisicao));
    }

}
