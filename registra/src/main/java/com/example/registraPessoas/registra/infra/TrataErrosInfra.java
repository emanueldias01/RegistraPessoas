package com.example.registraPessoas.registra.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TrataErrosInfra {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity error404(){
        return ResponseEntity.notFound().build();

    }

}
