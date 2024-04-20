package com.mateuscurso.pizzariadankicode.pizza;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
@RequiredArgsConstructor
public class PizzaController {

    private final PizzaService pizzaService;

@PostMapping
    public void cadastrar(@RequestBody @Valid PizzaDTO dto){

    pizzaService.criarPizza(dto);
}

@GetMapping
    public Page<PizzaDTO> buscarTodos(@PageableDefault(size = 10)Pageable paginacao){

    return pizzaService.buscarTodos(paginacao);
}

@GetMapping("/{id}")
    public PizzaDTO buscarPorID(@PathVariable @NotNull Long id){

    return pizzaService.buscarPorID(id);
}

@PutMapping("/{id}")
    public PizzaDTO atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid PizzaDTO dto){
    PizzaDTO pizzaAtualizada = pizzaService.atualizarPizza(id, dto);
    return pizzaAtualizada;
}

@DeleteMapping("/{id}")
    public void excluir(@PathVariable @NotNull Long id){
        pizzaService.excluir(id);
}
}
