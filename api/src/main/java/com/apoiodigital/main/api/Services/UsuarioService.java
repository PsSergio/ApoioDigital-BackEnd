package com.apoiodigital.main.api.Services;

import com.apoiodigital.main.api.Models.Usuario;
import com.apoiodigital.main.api.Repositories.UsuarioRepository;
import com.apoiodigital.main.api.exception.TelefoneAlreayExistsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String encriptografarSenha(Usuario usuario){
        return passwordEncoder.encode(usuario.getSenha());
    }

    public Usuario salvarUsuario(Usuario model){

        var doesUserExists = usuarioRepository.findByTelefone(model.getTelefone()).isPresent();

        if(doesUserExists) throw new TelefoneAlreayExistsException();

        model.validarSenha();
        var senhaEncriptografada = encriptografarSenha(model);
        model.setSenha( senhaEncriptografada );
        return usuarioRepository.save(model);
    }

    public Boolean validarLogin(String senha, String telefone){
        var optUsuario =  usuarioRepository.findByTelefone(telefone);

        if(optUsuario.isEmpty()){
            return false;
        }

        return passwordEncoder.matches( senha, optUsuario.get().getSenha() );
    }
}
