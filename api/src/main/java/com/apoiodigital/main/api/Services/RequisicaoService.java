package com.apoiodigital.main.api.Services;

import com.apoiodigital.main.api.Dtos.RequisicaoInputDTO;
import com.apoiodigital.main.api.Models.Requisicao;
import com.apoiodigital.main.api.Models.Usuario;
import com.apoiodigital.main.api.Repositories.RequisicaoRepository;
import com.apoiodigital.main.api.Repositories.UsuarioRepository;
import com.apoiodigital.main.api.exception.UsuarioDoesNotExistException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static jakarta.persistence.GenerationType.UUID;

@Service
public class RequisicaoService {

    private final RequisicaoRepository requisicaoRepository;
    private final UsuarioRepository usuarioRepository;

    public RequisicaoService(RequisicaoRepository requisicaoRepository, UsuarioRepository usuarioRepository) {
        this.requisicaoRepository = requisicaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Requisicao> salvarRequisicoesIniciais(UUID usuarioID) {
        var req1 = salvarRequisicao(new RequisicaoInputDTO("Me ajude a pedir comida pelo celular", usuarioID));
        var req2 = salvarRequisicao(new RequisicaoInputDTO("Me ajude a pedir uma carona de carro por aplicativo", usuarioID));
        var req3 = salvarRequisicao(new RequisicaoInputDTO("Me ajude a mandar uma mensagem por celular", usuarioID));

        var reqs = Arrays.asList(req1, req2, req3);
        requisicaoRepository.saveAll(reqs);
        return reqs;
    }

    public Requisicao salvarRequisicao(RequisicaoInputDTO dto){
        var requisicao = new Requisicao();
        var time = LocalDateTime.now();
        requisicao.setTimeStamp(time);
        requisicao.setPrompt(dto.prompt());

        var usuario = usuarioRepository.findById(dto.id_usuario());

        if(usuario.isEmpty()) throw  new UsuarioDoesNotExistException();

        requisicao.setUsuario(usuario.get());
        return requisicaoRepository.save(requisicao);
    }

    public List<Requisicao> carregarRequisicaoPeloUsuario(UUID id_usuario){

        var _usuario = usuarioRepository.findById(id_usuario);

        if(_usuario.isEmpty()) throw new UsuarioDoesNotExistException();

        return requisicaoRepository.findByUsuario(_usuario.get());
    }
}
