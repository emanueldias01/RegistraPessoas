package com.example.registraPessoas.registra.controllers;

import com.example.registraPessoas.registra.domain.user.DadosLoginDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    @Autowired
    private AuthenticationManager manager;

    @GetMapping
    public ResponseEntity efetuaLogin(@RequestBody @Valid DadosLoginDTO data){
        var token = new UsernamePasswordAuthenticationToken(data.login(),data.senha());
         manager.authenticate(token);
        return ResponseEntity.noContent().build();

    }
}
