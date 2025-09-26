package com.org.cine.controller;

import com.org.cine.model.Filme;
import com.org.cine.service.FilmeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
