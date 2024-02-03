package com.example.registraPessoas.registra.controllers;

import com.example.registraPessoas.registra.domain.user.DadosLoginDTO;
import com.example.registraPessoas.registra.domain.user.TokenService;
import com.example.registraPessoas.registra.domain.user.User;
import com.example.registraPessoas.registra.dto.tokenDTO;
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

    @Autowired
    TokenService tokenService;
    @PostMapping
    public ResponseEntity efetuaLogin(@RequestBody @Valid DadosLoginDTO data){
        var token = new UsernamePasswordAuthenticationToken(data.login(),data.password());
         var authentication = manager.authenticate(token);
         tokenDTO tokenDTO =new tokenDTO(tokenService.gerarToken((User) authentication.getPrincipal()));

        return ResponseEntity.ok(tokenDTO);

    }
}
