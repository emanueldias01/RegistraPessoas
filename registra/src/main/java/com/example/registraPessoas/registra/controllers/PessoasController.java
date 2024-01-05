package com.example.registraPessoas.registra.controllers;

import com.example.registraPessoas.registra.pessoa.Pessoa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoasController {

    @GetMapping
    public void getAllPeoples(){
        List<Pessoa> listPeoples
    }

}
