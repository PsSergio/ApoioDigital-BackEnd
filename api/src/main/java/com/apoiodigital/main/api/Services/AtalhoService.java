package com.apoiodigital.main.api.Services;

import com.apoiodigital.main.api.Models.Atalho;
import com.apoiodigital.main.api.Models.Requisicao;
import com.apoiodigital.main.api.Models.Usuario;
import com.apoiodigital.main.api.Repositories.AtalhoRepository;
import com.apoiodigital.main.api.Repositories.CategoriaAtalhoRepository;
import com.apoiodigital.main.api.Repositories.RequisicaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AtalhoService {

    private final AtalhoRepository atalhoRepository;
    private final CategoriaAtalhoRepository categoriaAtalhoRepository;
    private final RequisicaoRepository requisicaoRepository;

    public AtalhoService(AtalhoRepository atalhoRepository, CategoriaAtalhoRepository categoriaAtalhoRepository, RequisicaoRepository requisicaoRepository) {
        this.atalhoRepository = atalhoRepository;
        this.categoriaAtalhoRepository = categoriaAtalhoRepository;
        this.requisicaoRepository = requisicaoRepository;
    }

    public Atalho criarAtalho(Requisicao requisicao) {
        Atalho atalho = new Atalho();
        atalho.setPrompt(requisicao.getPrompt());
        atalho.setTitulo("Quero pedir comida"); // devera vir da IA atraves de um endpoint q recebe o prompt
        atalho.setUsuario(requisicao.getUsuario());
        var categoria = categoriaAtalhoRepository.findById(1L); // devera vir da IA tbm
        atalho.setCategoriaAtalho(categoria.get());
        return atalhoRepository.save(atalho);
    }

    public Requisicao iniciarAtalho(Atalho atalho){
        var requisicao = new Requisicao();
        var time = LocalDateTime.now();
        requisicao.setTimeStamp(time);
        requisicao.setPrompt(atalho.getPrompt());
        requisicao.setUsuario(atalho.getUsuario());
        return requisicaoRepository.save(requisicao);
    }

}
