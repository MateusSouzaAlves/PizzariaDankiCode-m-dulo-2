package com.mateuscurso.pizzariadankicode.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.mateuscurso.pizzariadankicode.usuario.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String criarToken(Usuario usuario){
        try {
            Algorithm algoritmo = Algorithm.HMAC256("1234");
            LocalDateTime dataExpiracao = LocalDateTime.now().plusHours(2);

            return JWT.create()
                    .withIssuer("Danki Code Pizzaria")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(dataExpiracao.toInstant(ZoneOffset.of("-03:00")))
                    .sign(algoritmo);

        } catch (JWTCreationException e){

            throw new RuntimeException("Erro ao criar token", e);

        }
    }

    public String buscaUsuarioToken(String token){
        try {
            Algorithm algoritmo = Algorithm.HMAC256("1234");

            return JWT.require(algoritmo)
                    .withIssuer("Danki Code Pizzaria")
                    .build()
                    .verify(token)
                    .getSubject();

        } catch (JWTVerificationException ex){
            throw new RuntimeException("Token incorreto!");
        }
    }
}
