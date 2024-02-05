package com.example.registraPessoas.registra.infra;

import com.example.registraPessoas.registra.domain.user.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        var tokenJWT = recuperarToken(request);

        var subject =tokenService.getSubject(tokenJWT);

        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var althorizationHeader = request.getHeader("Authorization");
        if(althorizationHeader == null){
            throw new RuntimeException("TOKEN NÃO ENVIADO NO CABEÇALHO AUTHORIZATION");
        }

        return althorizationHeader.replace("Bearer", "");
    }
}
