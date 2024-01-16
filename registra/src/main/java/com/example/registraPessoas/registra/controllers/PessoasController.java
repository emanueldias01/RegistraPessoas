package com.example.registraPessoas.registra.controllers;

import com.example.registraPessoas.registra.domain.dto.PessoaUpdateResponseDTO;
import com.example.registraPessoas.registra.domain.pessoa.Pessoa;
import com.example.registraPessoas.registra.domain.dto.PessoaRequestDTO;
import com.example.registraPessoas.registra.domain.dto.PessoaResponseDTO;
import com.example.registraPessoas.registra.domain.dto.PessoaUpdateDTO;
import com.example.registraPessoas.registra.domain.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pessoas")
public class PessoasController {

    @Autowired
    PessoaRepository repository;

    @GetMapping
    public ResponseEntity getAllPeoples(Pageable paginacao){
        Page<PessoaResponseDTO> listPeoples = repository.findAll(paginacao).map(PessoaResponseDTO::new);
        return ResponseEntity.ok(listPeoples);

    }

    @PostMapping
    @Transactional
    public ResponseEntity savePeople(@RequestBody @Valid PessoaRequestDTO data, UriComponentsBuilder uriBuilder){
        Pessoa pessoaData = new Pessoa(data);
        repository.save(pessoaData);

        var uri = uriBuilder.path("/{id}").buildAndExpand(pessoaData.getId()).toUri();

        return ResponseEntity.created(uri).body(new PessoaResponseDTO(pessoaData));
    }

    @PutMapping
    @Transactional
    public ResponseEntity updatePeople(@RequestBody PessoaUpdateDTO data){
        var pessoa = repository.getReferenceById(data.id());
        pessoa.uptadeInfo(data);
        PessoaUpdateResponseDTO response = new PessoaUpdateResponseDTO(pessoa);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletePeople(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity details(@PathVariable Long id){
        var detalhe = repository.getReferenceById(id);
        return ResponseEntity.ok(new PessoaResponseDTO(detalhe));

    }

}
