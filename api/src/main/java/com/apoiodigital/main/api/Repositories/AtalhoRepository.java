package com.apoiodigital.main.api.Repositories;

import com.apoiodigital.main.api.Models.Atalho;
import com.apoiodigital.main.api.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AtalhoRepository extends JpaRepository<Atalho, UUID> {

    List<Atalho> findByUsuario(Usuario usuario);

}
