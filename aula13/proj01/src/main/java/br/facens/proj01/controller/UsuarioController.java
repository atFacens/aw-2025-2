package br.facens.proj01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.facens.proj01.dto.RequestNewUser;
import br.facens.proj01.dto.UsuarioDTO;
import br.facens.proj01.model.Usuario;
import br.facens.proj01.service.UsuarioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

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

    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioDTO> getUsuario(@PathVariable @NotEmpty @Email String email) {
        Optional<UsuarioDTO> optionalUsuarioDTO = service.findUsuarioByEmail(email);

        if(optionalUsuarioDTO.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalUsuarioDTO.get());

    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        List<UsuarioDTO> usuarios = service.findAll();
        if(usuarios.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarios);
    }    

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> findAllFull() {
        List<Usuario> usuarios = service.findAllFull();
        if(usuarios.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarios);
    }    

    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@RequestBody @Valid RequestNewUser newUser) {
        UsuarioDTO insertdUser = service.createUsuario(newUser);
        return new ResponseEntity<UsuarioDTO>(insertdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable int id, @RequestBody RequestNewUser newUser) {
        UsuarioDTO updatedUser = service.updateUsuario(id, newUser);
        return new ResponseEntity<UsuarioDTO>(updatedUser, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UsuarioDTO> updateParticialUsuario(@PathVariable int id, @RequestBody RequestNewUser newUser) {
        Optional<UsuarioDTO> updatedUser = service.updatePartialUsuario(id, newUser);
        if(updatedUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<UsuarioDTO>(updatedUser.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteById(@PathVariable int id) {
        if(service.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
