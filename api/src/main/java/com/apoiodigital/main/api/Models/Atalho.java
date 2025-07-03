package com.apoiodigital.main.api.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "Atalho")
@Getter
@Setter
public class Atalho {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", columnDefinition = "VARCHAR(36)")
    @JsonIgnore
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_categoria", columnDefinition = "BIGINT")
    private CategoriaAtalho categoriaAtalho;

    @Column(name = "titulo", columnDefinition = "VARCHAR(30)")
    private String titulo;

    @Column(name = "prompt", columnDefinition = "VARCHAR(500)")
    private String prompt;

}
