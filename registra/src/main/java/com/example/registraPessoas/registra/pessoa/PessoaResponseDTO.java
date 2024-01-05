package com.example.registraPessoas.registra.pessoa;

public record PessoaResponseDTO(String nome, String email, int telefone) {
    public PessoaResponseDTO(Pessoa pessoa){
       this(pessoa.getNome(), pessoa.getEmail(), pessoa.getTelefone());
    }
}
