package com.org.cine.controller;

import com.org.cine.model.Filme;
import com.org.cine.service.FilmeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private final FilmeService service;

    public FilmeController(FilmeService service){
        this.service = service;
    }

    @GetMapping
    public List<Filme> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    public Filme listarPorId(@PathVariable Long id){
        return service.listarPorId(id);
    }

    @PostMapping
    public Filme inserir(@RequestBody Filme filme){
        return service.inserir(filme);
    }

    @PutMapping("/{id}")
    public Filme atualizar(@PathVariable Long id, @RequestBody Filme filme){
        return service.atualizar(id, filme);
    }

    @DeleteMapping("/{id}")
    public void deletar(Long id){
        service.deletar(id);
    }
}

