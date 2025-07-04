package com.apoiodigital.main.api.Controllers;

import com.apoiodigital.main.api.Dtos.CompoentsAndContextDTO;
import com.apoiodigital.main.api.Dtos.RespostaResponse;
import com.apoiodigital.main.api.Models.Requisicao;
import com.apoiodigital.main.api.Services.RespostaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/resposta/")
public class RespostaController {

    private final RespostaService respostaService;

    public RespostaController(RespostaService respostaService) {
        this.respostaService = respostaService;
    }

    @PostMapping("/exigir")
    public ResponseEntity<RespostaResponse> ExigirRespostaDaIA(@RequestParam UUID id_requisicao, @RequestBody CompoentsAndContextDTO body){
        return ResponseEntity.ok().body(respostaService.salvarResposta(id_requisicao, body));
    }

}
