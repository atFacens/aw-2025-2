package br.facens.proj01.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facens.proj01.dto.RequestNewUser;
import br.facens.proj01.dto.UsuarioDTO;
import br.facens.proj01.model.Usuario;
import br.facens.proj01.repository.UsuarioRepo;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo repo;

    public UsuarioDTO createUsuario(RequestNewUser newUser) {
        Usuario usuario = repo.save(newUser.toUsuario());
        return new UsuarioDTO(usuario);
    }

    public Optional<UsuarioDTO> findUsuario(int id) {
        Optional<Usuario> usuarioOptinal = repo.findById(id);
        if (usuarioOptinal.isEmpty()) {
            return Optional.empty();
        }
        Usuario usuario = usuarioOptinal.get();
        return Optional.of(new UsuarioDTO(usuario));
    }

    public List<UsuarioDTO> findAll() {
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        repo.findAll().forEach((usuario)->{
            usuariosDTO.add(new UsuarioDTO(usuario));
        });
        return usuariosDTO;
    }
}
