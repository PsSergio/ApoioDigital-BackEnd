package com.apoiodigital.main.api.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CategoriaAtalho")
@Getter
@Setter
public class CategoriaAtalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", columnDefinition = "BIGINT")
    private Long id;

    @Column(name = "categoria", columnDefinition = "VARCHAR(50)")
    private String categoria;

}
