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

    public Optional<UsuarioDTO> findUsuarioByEmail(String email) {
        Optional<Usuario> usuarioOptinal = repo.findByEmail(email);
        if (usuarioOptinal.isEmpty()) {
            return Optional.empty();
        }
        Usuario usuario = usuarioOptinal.get();
        return Optional.of(new UsuarioDTO(usuario));
    }

    public List<UsuarioDTO> findAll() {
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        repo.findAll().forEach((usuario) -> {
            usuariosDTO.add(new UsuarioDTO(usuario));
        });
        return usuariosDTO;
    }

    public UsuarioDTO updateUsuario(int id, RequestNewUser newUser) {
        Usuario usuario = newUser.toUsuario();
        usuario.setId(id);

        Usuario usuarioUpdated = repo.save(usuario);
        return new UsuarioDTO(usuarioUpdated);
    }

    public Optional<UsuarioDTO> updatePartialUsuario(int id, RequestNewUser newUser) {
        Optional<Usuario> optUsuario = repo.findById(id);

        if (optUsuario.isEmpty()) {
            return Optional.empty();
        }

        Usuario usuario = optUsuario.get();

        if (newUser.getNome() != null) {
            usuario.setNome(newUser.getNome());
        }

        if (newUser.getEmail() != null) {
            usuario.setEmail(newUser.getEmail());
        }

        if (newUser.getSenha() != null) {
            usuario.setSenha(newUser.getSenha());
        }

        Usuario usuarioUpdated = repo.save(usuario);
        return Optional.of(new UsuarioDTO(usuarioUpdated));
    }

    public boolean deleteById(int id) {
        Optional<Usuario> optUsuario = repo.findById(id);
        if(optUsuario.isEmpty()) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }
}
