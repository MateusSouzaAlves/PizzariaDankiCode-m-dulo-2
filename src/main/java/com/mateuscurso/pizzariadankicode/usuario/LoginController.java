package com.mateuscurso.pizzariadankicode.usuario;

import com.mateuscurso.pizzariadankicode.config.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationManager autenticador;

    private final TokenService tokenService;

    @PostMapping
    public ResponseEntity validacaoCredenciaisUsuario(@RequestBody @Valid CredenciaisUsuarioDTO credenciais){
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(credenciais.getLogin(),credenciais.getPassword());
        Authentication autenticacao = autenticador.authenticate(token);

        return  ResponseEntity.ok(tokenService.criarToken((Usuario) autenticacao.getPrincipal()));
    }
}
