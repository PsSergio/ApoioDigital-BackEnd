package com.apoiodigital.main.api.Services;

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


    public Resposta salvarResposta(Requisicao requisicao){
        var resposta = new Resposta();
        resposta.setRequsicao(requisicao);
        resposta.setMensagem("Clique neste aplicativo");
        resposta.setTimestamp(LocalDateTime.now());

        return respostaRepository.save(resposta);
    }

}
