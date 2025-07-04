package com.apoiodigital.main.api.Controllers;

import com.apoiodigital.main.api.Dtos.RequisicaoInputDTO;
import com.apoiodigital.main.api.Models.Requisicao;
import com.apoiodigital.main.api.Models.Usuario;
import com.apoiodigital.main.api.Services.RequisicaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/requisicao")
public class RequisicaoController {

    private final RequisicaoService requisicaoService;

    public RequisicaoController(RequisicaoService requisicaoService) {
        this.requisicaoService = requisicaoService;
    }

    @PostMapping("/enviar")
    public ResponseEntity<Requisicao> enviarRequisicao(@RequestBody RequisicaoInputDTO dto){
        return ResponseEntity.ok().body(requisicaoService.salvarRequisicao(dto));
    }

    @GetMapping("/carregar/usuario/todos")
    public ResponseEntity<List<Requisicao>> carregarListaHistorico(@RequestParam UUID id_usuario){
        return ResponseEntity.ok().body(requisicaoService.carregarRequisicaoPeloUsuario(id_usuario));
    }
}
