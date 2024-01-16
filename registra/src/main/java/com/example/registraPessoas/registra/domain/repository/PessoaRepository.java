package com.example.registraPessoas.registra.domain.repository;

import com.example.registraPessoas.registra.domain.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
