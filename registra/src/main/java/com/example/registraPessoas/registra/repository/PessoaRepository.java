package com.example.registraPessoas.registra.repository;

import com.example.registraPessoas.registra.pessoa.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
