package br.facens.proj01.dto;

import br.facens.proj01.model.Usuario;

public class RequestNewUser {
    private String nome;
    private String email;
    private String senha;

    public RequestNewUser(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario toUsuario() {
        return new Usuario(nome, email, senha);
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

}
