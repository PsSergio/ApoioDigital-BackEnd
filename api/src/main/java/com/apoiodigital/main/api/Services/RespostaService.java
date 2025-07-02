package com.apoiodigital.main.api.Services;

import com.apoiodigital.main.api.Dtos.BoundsDTO;
import com.apoiodigital.main.api.Dtos.CompoentsAndContextDTO;
import com.apoiodigital.main.api.Dtos.IdentifierComponentDTO;
import com.apoiodigital.main.api.Dtos.RespostaResponse;
import com.apoiodigital.main.api.Models.Requisicao;
import com.apoiodigital.main.api.Models.Resposta;
import com.apoiodigital.main.api.Repositories.RespostaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RespostaService {

    private final RespostaRepository respostaRepository;

    public RespostaService(RespostaRepository respostaRepository) {
        this.respostaRepository = respostaRepository;
    }

    public RespostaResponse salvarResposta(Requisicao requisicao, CompoentsAndContextDTO componentsAndContext){
        // exemplo de resposta esperada pela IA

        var resposta = new Resposta();
        resposta.setRequsicao(requisicao);
        resposta.setMensagem("Clique neste aplicativo"); // devera vir da IA
        resposta.setTimestamp(LocalDateTime.now());

        var respostaDB = respostaRepository.save(resposta);
        var identifierComp = new IdentifierComponentDTO(1, new BoundsDTO(200.0, 300.0, 500.0, 600.0)); // devera vir da IA

        return new RespostaResponse(respostaDB, identifierComp);
    }

}
