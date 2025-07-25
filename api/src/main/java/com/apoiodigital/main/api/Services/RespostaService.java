package com.apoiodigital.main.api.Services;

import com.apoiodigital.main.api.Dtos.CompoentsAndContextDTO;
import com.apoiodigital.main.api.Dtos.IdentifierComponentDTO;
import com.apoiodigital.main.api.Dtos.RespostaResponse;
import com.apoiodigital.main.api.Models.Resposta;
import com.apoiodigital.main.api.Repositories.RequisicaoRepository;
import com.apoiodigital.main.api.Repositories.RespostaRepository;
import com.apoiodigital.main.api.exception.RequisicaoDoesNotExistException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RespostaService {

    private final RespostaRepository respostaRepository;
    private final RequisicaoRepository requisicaoRepository;

    public RespostaService(RespostaRepository respostaRepository, RequisicaoRepository requisicaoRepository) {
        this.respostaRepository = respostaRepository;
        this.requisicaoRepository = requisicaoRepository;
    }

    public RespostaResponse salvarResposta(UUID id_requisicao, CompoentsAndContextDTO componentsAndContext){
        var optRequisicao = requisicaoRepository.findById(id_requisicao);

        if(optRequisicao.isEmpty()) throw new RequisicaoDoesNotExistException();

        var resposta = new Resposta();
        resposta.setRequsicao(optRequisicao.get());
        resposta.setMensagem("Clique neste aplicativo"); // devera vir da IA
        resposta.setTimestamp(LocalDateTime.now());

        var respostaDB = respostaRepository.save(resposta);

        var viewID = 2; // devera vir da IA

        var bounds = componentsAndContext.components().get(viewID-1).bounds();

        var identifierComp = new IdentifierComponentDTO(viewID, bounds);

        return new RespostaResponse(respostaDB, identifierComp);
    }

}
