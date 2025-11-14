package br.facens.proj01.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.facens.proj01.exceptions.ProjetoNotFoundException;
import br.facens.proj01.model.Projeto;
import br.facens.proj01.repository.ProjetoRepo;

@Service
public class ProjetoService {
    
    @Autowired
    ProjetoRepo repo;

    public Projeto findById(int id) {
        Optional<Projeto> optional =  repo.findById(id);

        if(optional.isEmpty()) {
            throw new ProjetoNotFoundException("Produto Id = " + id);
        }
        return optional.get();
    }
}
