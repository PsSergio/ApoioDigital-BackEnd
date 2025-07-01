package com.apoiodigital.main.api.Models;

import com.apoiodigital.main.api.exception.InvalidPasswordLengthException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="Usuario")
public class Usuario {

    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(name = "nome", columnDefinition = "VARCHAR(50)")
    private String nome;

    @Column(name = "telefone", columnDefinition = "VARCHAR(11)", unique = true)
    private String telefone;

    @Column(name = "senha", columnDefinition = "VARCHAR(255)")
    private String senha;

    public void validarSenha(){
        if(this.senha.length() < 8) throw new InvalidPasswordLengthException();

    }

}
