package com.example.registraPessoas.registra.controllers;

import com.example.registraPessoas.registra.pessoa.PessoaResponseDTO;
import com.example.registraPessoas.registra.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("pessoas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PessoasController {

    @Autowired
    PessoaRepository repository;

    @GetMapping
    public List<PessoaResponseDTO> getAllPeoples(){
        List<PessoaResponseDTO> listPeoples = repository.findAll().stream().map(PessoaResponseDTO::new).toList();
        return listPeoples;
    }

}
