package br.facens.proj01.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.facens.proj01.model.Usuario;

@Repository
// CRUD = Create, Read, Update, Delete
public class UsuarioRepo {
    private List<Usuario>  usuarios = new ArrayList<>();

    public UsuarioRepo() {
        usuarios.add(new Usuario(1, "Emerson", "emerson@paduan.dev.br", "1234"));
        usuarios.add(new Usuario(2, "Paduan", "paduan@paduan.dev.br", "1234"));
    }

    public Optional<Usuario> findUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if(usuario.getId() == id) {
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }

    
}
