package com.apoiodigital.main.api.Services;

import com.apoiodigital.main.api.Dtos.RequisicaoInputDTO;
import com.apoiodigital.main.api.Models.Requisicao;
import com.apoiodigital.main.api.Repositories.RequisicaoRepository;
import com.apoiodigital.main.api.Repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RequisicaoService {

    private final RequisicaoRepository requisicaoRepository;
    private final UsuarioRepository usuarioRepository;

    public RequisicaoService(RequisicaoRepository requisicaoRepository, UsuarioRepository usuarioRepository) {
        this.requisicaoRepository = requisicaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Requisicao salvarRequisicao(RequisicaoInputDTO dto){
        var requisicao = new Requisicao();
        var time = LocalDateTime.now();
        requisicao.setTimeStamp(time);
        requisicao.setPrompt(dto.prompt());
        requisicao.setUsuario(usuarioRepository.findById(dto.id_usuario()).get());
        return requisicaoRepository.save(requisicao);
    }
}
