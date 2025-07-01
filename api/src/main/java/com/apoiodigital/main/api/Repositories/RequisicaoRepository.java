package com.apoiodigital.main.api.Repositories;

import com.apoiodigital.main.api.Models.Requisicao;
import com.apoiodigital.main.api.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RequisicaoRepository extends JpaRepository<Requisicao, UUID> {

    List<Requisicao> findByUsuario(Usuario usuario);

}
