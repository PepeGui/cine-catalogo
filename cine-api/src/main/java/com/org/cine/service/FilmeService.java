package com.org.cine.service;

import com.org.cine.model.Filme;
import com.org.cine.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository){
        this.repository = repository;
    }

    public List<Filme> listar(){
        return repository.findAll();
    }


}
