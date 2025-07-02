package com.apoiodigital.main.api.Repositories;

import com.apoiodigital.main.api.Models.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RespostaRepository extends JpaRepository<Resposta, UUID> {
}
