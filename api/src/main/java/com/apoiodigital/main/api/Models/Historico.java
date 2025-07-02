package com.apoiodigital.main.api.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Resposta")
public class Historico {

    @Id
    private Long id;

    private String printScreen;

    private Resposta resposta;

    @JsonIgnore
    private Requisicao requisicao;

}
