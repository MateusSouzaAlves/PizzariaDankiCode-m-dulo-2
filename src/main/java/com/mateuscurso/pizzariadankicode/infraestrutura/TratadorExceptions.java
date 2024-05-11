package com.mateuscurso.pizzariadankicode.infraestrutura;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorExceptions {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarException404(){
        return ResponseEntity.notFound().build();

    }
}
