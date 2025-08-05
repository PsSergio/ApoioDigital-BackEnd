package com.apoiodigital.main.api.Controllers;

import com.apoiodigital.main.api.Dtos.IARequestDTO;
import com.apoiodigital.main.api.Dtos.IAResponseDTO;
import com.apoiodigital.main.api.Models.Resposta;
import com.apoiodigital.main.api.Services.RespostaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resposta/")
public class RespostaController {

    private final RespostaService respostaService;

    public RespostaController(RespostaService respostaService) {
        this.respostaService = respostaService;
    }

    @PostMapping("/exigir")
    public ResponseEntity<IAResponseDTO> exigirRespostaDaIA(@RequestBody IARequestDTO body){
        var response = respostaService.responseFlask(body);
            return ResponseEntity.ok().body(response);

    }

    @PostMapping("/salvar")
    public ResponseEntity<Resposta> salvarResposta(@RequestBody Resposta resposta){
        var response = respostaService.salvarResposta(resposta);
        return ResponseEntity.ok(response);
    }

}
