package br.facens.proj01.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.facens.proj01.model.Usuario;

@Service
public class UsuarioService {
    
    public Optional<Usuario> findUsuario(int id) {
        if(id == 1){
            Usuario usuario = new Usuario(id, "Emerson Paduan", "emerson@paduan.dev.br");
            return Optional.of(usuario);
        }
        return Optional.empty();
    }
}
