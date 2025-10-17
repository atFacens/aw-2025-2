package br.facens.proj01.dto;

import br.facens.proj01.model.Usuario;

public class UsuarioDTO {
    private int id;
    private String nome;
    private String email;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();   
        this.email = usuario.getEmail();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

}
