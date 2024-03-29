package com.example.registraPessoas.registra.domain.dto;

import com.example.registraPessoas.registra.domain.pessoa.Pessoa;

public record PessoaUpdateResponseDTO(Long id, String nome, String email, String telefone ) {

    public PessoaUpdateResponseDTO(Pessoa pessoa) {
       this(pessoa.getId(), pessoa.getNome(), pessoa.getEmail(), pessoa.getTelefone());
    }
}
