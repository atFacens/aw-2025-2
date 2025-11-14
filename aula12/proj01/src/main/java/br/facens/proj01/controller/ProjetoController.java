package br.facens.proj01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facens.proj01.model.Projeto;
import br.facens.proj01.service.ProjetoService;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {
    
    @Autowired
    ProjetoService service;

    @GetMapping("/{id}")
    public ResponseEntity<Projeto> findById(@PathVariable int id) {
        Projeto projeto = service.findById(id);
        return ResponseEntity.ok(projeto);
    }

}
