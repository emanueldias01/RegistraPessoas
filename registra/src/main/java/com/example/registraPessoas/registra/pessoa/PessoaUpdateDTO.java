package com.example.registraPessoas.registra.pessoa;

import jakarta.validation.constraints.NotNull;

public record PessoaUpdateDTO(
        @NotNull
        Long id,
        String email,
        String telefone) {
}
