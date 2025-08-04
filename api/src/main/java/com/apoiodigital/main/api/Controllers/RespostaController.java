package com.apoiodigital.main.api.Controllers;

import com.apoiodigital.main.api.Dtos.CompoentsAndContextDTO;
import com.apoiodigital.main.api.Dtos.RespostaResponse;
import com.apoiodigital.main.api.Models.Requisicao;
import com.apoiodigital.main.api.Models.Resposta;
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
    public ResponseEntity<String> exigirRespostaDaIA(@RequestParam UUID id_requisicao, @RequestBody String body){
        var response = respostaService.responseFlask(id_requisicao, body);
        if(!response.isEmpty()){
            return ResponseEntity.ok().body(response);
        }else{
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity<Resposta> salvarResposta(@RequestBody Resposta resposta){
        var response = respostaService.salvarResposta(resposta);
        return ResponseEntity.ok(response);
    }

}
