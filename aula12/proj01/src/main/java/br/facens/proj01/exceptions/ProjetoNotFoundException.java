package br.facens.proj01.exceptions;

public class ProjetoNotFoundException extends RuntimeException {
    public ProjetoNotFoundException(String msg) {
        super(msg);
    }
}
