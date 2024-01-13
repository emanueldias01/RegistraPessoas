package com.example.registraPessoas.registra.controllers;

import com.example.registraPessoas.registra.pessoa.Pessoa;
import com.example.registraPessoas.registra.pessoa.PessoaRequestDTO;
import com.example.registraPessoas.registra.pessoa.PessoaResponseDTO;
import com.example.registraPessoas.registra.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoasController {

    @Autowired
    PessoaRepository repository;

    @GetMapping
    public List<PessoaResponseDTO> getAllPeoples(){
        List<PessoaResponseDTO> listPeoples = repository.findAll().stream().map(PessoaResponseDTO::new).toList();
        return listPeoples;
    }

    @PostMapping
    public void savePeople(@RequestBody @Valid PessoaRequestDTO data){
        Pessoa pessoaData = new Pessoa(data);
        repository.save(pessoaData);

    }

}
