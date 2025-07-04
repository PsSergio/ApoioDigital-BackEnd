package com.apoiodigital.main.api.Services;

import com.apoiodigital.main.api.Models.Atalho;
import com.apoiodigital.main.api.Models.Requisicao;
import com.apoiodigital.main.api.Models.Usuario;
import com.apoiodigital.main.api.Repositories.AtalhoRepository;
import com.apoiodigital.main.api.Repositories.CategoriaAtalhoRepository;
import com.apoiodigital.main.api.Repositories.RequisicaoRepository;
import com.apoiodigital.main.api.Repositories.UsuarioRepository;
import com.apoiodigital.main.api.exception.AtalhoDoesNotExistException;
import com.apoiodigital.main.api.exception.RequisicaoDoesNotExistException;
import com.apoiodigital.main.api.exception.UsuarioDoesNotExistException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class AtalhoService {

    private final AtalhoRepository atalhoRepository;
    private final CategoriaAtalhoRepository categoriaAtalhoRepository;
    private final RequisicaoRepository requisicaoRepository;
    private final UsuarioRepository usuarioRepository;

    public AtalhoService(AtalhoRepository atalhoRepository, CategoriaAtalhoRepository categoriaAtalhoRepository, RequisicaoRepository requisicaoRepository, UsuarioRepository usuarioRepository) {
        this.atalhoRepository = atalhoRepository;
        this.categoriaAtalhoRepository = categoriaAtalhoRepository;
        this.requisicaoRepository = requisicaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Atalho criarAtalho(UUID id_requisicao) {
        var optRequisicao =  requisicaoRepository.findById(id_requisicao);
        if(optRequisicao.isEmpty()) throw new RequisicaoDoesNotExistException();
        var requisicao = optRequisicao.get();

        Atalho atalho = new Atalho();
        atalho.setPrompt(requisicao.getPrompt());
        atalho.setTitulo("Quero pedir comida"); // devera vir da IA atraves de um endpoint q recebe o prompt
        atalho.setUsuario(requisicao.getUsuario());

        var categoria = categoriaAtalhoRepository.findById(1L); // devera vir da IA tbm
        atalho.setCategoriaAtalho(categoria.get());

        return atalhoRepository.save(atalho);
    }

    public Requisicao iniciarAtalho(UUID id_atalho){

        var optAtalho = atalhoRepository.findById(id_atalho);
        if(optAtalho.isEmpty()) throw new AtalhoDoesNotExistException();
        var atalho = optAtalho.get();

        var requisicao = new Requisicao();
        var time = LocalDateTime.now();

        requisicao.setTimeStamp(time);
        requisicao.setPrompt(atalho.getPrompt());
        requisicao.setUsuario(atalho.getUsuario());

        return requisicaoRepository.save(requisicao);
    }

    public List<Atalho> carregarAtalhos(UUID id_usuario){
        var optUsuario = usuarioRepository.findById(id_usuario);
        if(optUsuario.isEmpty()) throw new UsuarioDoesNotExistException();

        var atalhos = atalhoRepository.findByUsuario(optUsuario.get());

        if(atalhos.size() < 3) return atalhos.subList(0, atalhos.size());
        return atalhos.subList(0, 3);
    }

}
