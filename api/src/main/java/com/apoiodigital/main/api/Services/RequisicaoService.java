package com.apoiodigital.main.api.Services;

import com.apoiodigital.main.api.Dtos.RequisicaoInputDTO;
import com.apoiodigital.main.api.Models.Requisicao;
import com.apoiodigital.main.api.Models.Usuario;
import com.apoiodigital.main.api.Repositories.RequisicaoRepository;
import com.apoiodigital.main.api.Repositories.UsuarioRepository;
import com.apoiodigital.main.api.exception.UsuarioDoesNotExistException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
