package com.example.registraPessoas.registra.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pessoas")
public class PessoasController {

    @GetMapping
    public ResponseEntity getAllPeoples(){
        return ResponseEntity.ok("tudo certo");
    }

}
