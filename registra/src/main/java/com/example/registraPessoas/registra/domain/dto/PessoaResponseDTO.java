package com.example.registraPessoas.registra.domain.dto;

import com.example.registraPessoas.registra.domain.pessoa.Pessoa;

public record PessoaResponseDTO(Long id, String nome, String email, String telefone) {
    public PessoaResponseDTO(Pessoa pessoa){
       this(pessoa.getId(),pessoa.getNome(), pessoa.getEmail(), pessoa.getTelefone());
    }
}
