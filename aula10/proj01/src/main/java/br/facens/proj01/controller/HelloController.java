package br.facens.proj01.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController { // Bean
    
    @GetMapping("/{nome}")
    public ResponseEntity<String> boaNoite(@PathVariable String nome) {
        if(nome.equalsIgnoreCase("Emerson"))
            return ResponseEntity.ok("Boa noite! " + nome);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/{nome}")
    public ResponseEntity<String> inserir(@PathVariable String nome) {
        return ResponseEntity.status(HttpStatus.CREATED).body(nome);
    }

}
