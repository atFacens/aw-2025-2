package br.facens.proj01.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facens.proj01.dto.UsuarioDTO;
import br.facens.proj01.model.Usuario;
import br.facens.proj01.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired // injeção de dependência
    UsuarioService service;

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable int id) {
        Optional<UsuarioDTO> optionalUsuarioDTO = service.findUsuario(id);

        if(optionalUsuarioDTO.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalUsuarioDTO.get());

        // if (optionalUsuario.isPresent()) {
        //     return ResponseEntity.ok(optionalUsuario.get());
        // }
        // return ResponseEntity.notFound().build();

    }
}
