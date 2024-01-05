package com.example.registraPessoas.registra.pessoa;

import jakarta.persistence.*;

@Entity
@Table(name = "Pessoas")
public class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    private String nome;
    private String email;
    private int telefone;
}
