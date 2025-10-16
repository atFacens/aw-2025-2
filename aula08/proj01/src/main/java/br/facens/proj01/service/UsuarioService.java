package br.facens.proj01.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facens.proj01.dto.UsuarioDTO;
import br.facens.proj01.model.Usuario;
import br.facens.proj01.repository.UsuarioRepo;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepo repo;

    public Optional<UsuarioDTO> findUsuario(int id) {
        Optional<Usuario> usuarioOptinal = repo.findById(id);
        if(usuarioOptinal.isEmpty()) {
            return Optional.empty();
        }
        Usuario usuario = usuarioOptinal.get();
        return Optional.of(new UsuarioDTO(usuario));
    }
}
