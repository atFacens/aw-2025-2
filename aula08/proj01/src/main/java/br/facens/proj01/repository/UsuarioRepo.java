package br.facens.proj01.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.facens.proj01.model.Usuario;

@Repository
// CRUD = Create, Read, Update, Delete
public interface UsuarioRepo extends CrudRepository<Usuario, Integer> {

    
}
