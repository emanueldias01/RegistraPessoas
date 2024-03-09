package com.example.registraPessoas.registra.controllers;

import com.example.registraPessoas.registra.domain.dto.PessoaUpdateResponseDTO;
import com.example.registraPessoas.registra.domain.pessoa.Pessoa;
import com.example.registraPessoas.registra.domain.dto.PessoaRequestDTO;
import com.example.registraPessoas.registra.domain.dto.PessoaResponseDTO;
import com.example.registraPessoas.registra.domain.dto.PessoaUpdateDTO;
import com.example.registraPessoas.registra.domain.repository.PessoaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("pessoas")
@SecurityRequirement(name = "bearer-key")
public class PessoasController {

    LocalDateTime timeLog = LocalDateTime.now();
    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    String horarioAtual = timeLog.format(formato);

    @Autowired
    PessoaRepository repository;

    @GetMapping
    @Operation(description = "Retorna as pessoas registradas")
    public ResponseEntity getAllPeoples(Pageable paginacao){
        Page<PessoaResponseDTO> listPeoples = repository.findAll(paginacao).map(PessoaResponseDTO::new);
        return ResponseEntity.ok(listPeoples);

    }

    @PostMapping
    @Transactional
    @Operation(description = "Salva uma pessoa com os parâmetros enviados via JSON")
    public ResponseEntity savePeople(@RequestBody @Valid PessoaRequestDTO data, UriComponentsBuilder uriBuilder){
        Pessoa pessoaData = new Pessoa(data);
        repository.save(pessoaData);
        System.out.println("POST: " + pessoaData.toString());
        System.out.println("TIME OPERATION: " + horarioAtual);

        var uri = uriBuilder.path("/{id}").buildAndExpand(pessoaData.getId()).toUri();

        return ResponseEntity.created(uri).body(new PessoaResponseDTO(pessoaData));
    }

    @PutMapping
    @Transactional
    @Operation(description = "Edita uma pessoa com os parâmetros enviados via JSON (IDENTIFIQUE A PESSOA QUE DESEJA EDITAR PELO ID")
    public ResponseEntity updatePeople(@RequestBody PessoaUpdateDTO data){
        var pessoa = repository.getReferenceById(data.id());
        pessoa.uptadeInfo(data);
        PessoaUpdateResponseDTO response = new PessoaUpdateResponseDTO(pessoa);
        System.out.println("PUT IN: " + pessoa.toString());
        System.out.println("TIME OPERATION: " + horarioAtual);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(description = "Deleta uma pessoa pelo id passado na URL")
    public ResponseEntity deletePeople(@PathVariable Long id){
        var deletado = repository.getReferenceById(id);
        repository.deleteById(id);
        System.out.println("DELETE PESSOA: " + deletado.toString());
        System.out.println("TIME OPERATION: " + horarioAtual);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @Operation(description = "Retorna uma pessoa pelo id passado na URL")
    public ResponseEntity details(@PathVariable Long id){
        var detalhe = repository.getReferenceById(id);
        System.out.println("GET PESSOA: " + detalhe.toString());
        System.out.println("TIME OPERATION: " + horarioAtual);
        return ResponseEntity.ok(new PessoaResponseDTO(detalhe));

    }

}
