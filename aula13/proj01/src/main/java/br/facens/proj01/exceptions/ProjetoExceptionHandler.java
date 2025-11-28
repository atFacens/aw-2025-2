package br.facens.proj01.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProjetoExceptionHandler {

    @ExceptionHandler(ProjetoNotFoundException.class)
    public ResponseEntity<DetailsException> projetoNotFound(ProjetoNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new DetailsException("Produto não encontrado", ex.getMessage()));
    }

}
