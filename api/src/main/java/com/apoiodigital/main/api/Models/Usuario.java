package com.apoiodigital.main.api.Models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Usuario {

    private UUID id;
    private String nome;
    private String telefone;
    private String senha;

}
