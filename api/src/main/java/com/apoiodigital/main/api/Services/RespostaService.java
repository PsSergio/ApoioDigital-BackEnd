package com.apoiodigital.main.api.Services;

import com.apoiodigital.main.api.Dtos.CompoentsAndContextDTO;
import com.apoiodigital.main.api.Dtos.IdentifierComponentDTO;
import com.apoiodigital.main.api.Dtos.RespostaResponse;
import com.apoiodigital.main.api.Models.Resposta;
import com.apoiodigital.main.api.Repositories.RequisicaoRepository;
import com.apoiodigital.main.api.Repositories.RespostaRepository;
import com.apoiodigital.main.api.exception.RequisicaoDoesNotExistException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.util.UUID;
import java.net.URI;
import java.net.http.HttpClient;

@Service
public class RespostaService {

    private final RespostaRepository respostaRepository;
    private final RequisicaoRepository requisicaoRepository;

    public RespostaService(RespostaRepository respostaRepository, RequisicaoRepository requisicaoRepository) {
        this.respostaRepository = respostaRepository;
        this.requisicaoRepository = requisicaoRepository;
    }

    public Resposta salvarResposta(Resposta resposta){

        return respostaRepository.save(resposta);
    }
    public String responseFlask(UUID id_requisicao, String infoCriptografada){
        String uri = "http://localhost:5000/api/assist";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .POST(HttpRequest.BodyPublishers.ofString(infoCriptografada))
                .header("Content-Type", "application/json")
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }

}
