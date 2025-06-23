package com.apoiodigital.main.api.Repositories;

import com.apoiodigital.main.api.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
}
