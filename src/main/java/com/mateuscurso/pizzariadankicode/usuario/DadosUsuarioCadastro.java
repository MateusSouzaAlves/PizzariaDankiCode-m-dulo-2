package com.mateuscurso.pizzariadankicode.usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DadosUsuarioCadastro {
    private Long id;
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
