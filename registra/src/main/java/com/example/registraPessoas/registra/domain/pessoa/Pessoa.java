package com.example.registraPessoas.registra.domain.pessoa;

import com.example.registraPessoas.registra.domain.dto.PessoaRequestDTO;
import com.example.registraPessoas.registra.domain.dto.PessoaUpdateDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Pessoas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public Pessoa(PessoaRequestDTO data) {
        this.nome = data.nome();
        this.email = data.email();
        this.telefone = data.telefone();

    }



    public void uptadeInfo(PessoaUpdateDTO data) {
        if(data.email() != null){
            this.email = data.email();
        }

        if(data.telefone() != null){
            this.telefone = data.telefone();
        }

    }
}
