package com.example.registraPessoas.registra.pessoa;

public record PessoaResponseDTO(Long id,String nome, String email, String telefone) {
    public PessoaResponseDTO(Pessoa pessoa){
       this(pessoa.getId(),pessoa.getNome(), pessoa.getEmail(), pessoa.getTelefone());
    }
}
