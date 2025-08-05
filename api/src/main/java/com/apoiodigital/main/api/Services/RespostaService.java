package com.apoiodigital.main.api.Services;

import com.apoiodigital.main.api.Dtos.IARequestDTO;
import com.apoiodigital.main.api.Dtos.IAResponseDTO;
import com.apoiodigital.main.api.Models.Resposta;
import com.apoiodigital.main.api.Repositories.RequisicaoRepository;
import com.apoiodigital.main.api.Repositories.RespostaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
    public IAResponseDTO responseFlask(IARequestDTO iaRequestDTO) {
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            String json = objectMapper.writeValueAsString(iaRequestDTO);

            String uri = "http://localhost:5000/api/assist";
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .header("Content-Type", "application/json")
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), IAResponseDTO.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
