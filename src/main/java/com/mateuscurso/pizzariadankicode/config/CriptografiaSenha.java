package com.mateuscurso.pizzariadankicode.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriptografiaSenha {

        private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        public static String criptografia( String senha){
            return encoder.encode(senha);
        }
}
