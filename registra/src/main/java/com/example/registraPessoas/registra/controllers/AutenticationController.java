package com.example.registraPessoas.registra.controllers;

import com.example.registraPessoas.registra.domain.user.DadosLoginDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticationController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity efetuaLogin(@RequestBody @Valid DadosLoginDTO data){
        var token = new UsernamePasswordAuthenticationToken(data.login(),data.password());
         manager.authenticate(token);
        return ResponseEntity.noContent().build();

    }
}
