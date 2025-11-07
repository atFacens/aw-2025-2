package br.facens.proj01.repository;

import org.springframework.data.repository.CrudRepository;

import br.facens.proj01.model.Projeto;

public interface ProjetoRepo extends CrudRepository<Projeto, Integer>{
    
}
