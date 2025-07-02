package com.apoiodigital.main.api.Controllers;

import com.apoiodigital.main.api.Models.Historico;
import com.apoiodigital.main.api.Models.Requisicao;
import com.apoiodigital.main.api.Models.Resposta;
import com.apoiodigital.main.api.Services.HistoricoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/historico")
public class HistoricoController {

    private final HistoricoService historicoService;

    public HistoricoController(HistoricoService historicoService) {
        this.historicoService = historicoService;
    }

    @PostMapping(path = "/salvar-printscreen", consumes = "multipart/form-data")
    public ResponseEntity<Historico> salvarPrintScreen(@RequestPart("printScreen")MultipartFile printScreen, @RequestParam Resposta resposta) throws IOException{
        return ResponseEntity.ok(historicoService.salvarPrintScreen(printScreen, resposta));
    }

    @GetMapping("/carregar")
    public ResponseEntity<List<Historico>> carregarTodosPelaRequisica(@RequestParam Requisicao requisicao){
        return ResponseEntity.ok(historicoService.carregarPelaRequisicao(requisicao));
    }

}
