package com.org.cine.service;

import com.org.cine.model.Diretor;
import com.org.cine.repository.DiretorRepository;

import java.util.List;

public class DiretorService {

    private final DiretorRepository repository;

    public DiretorService(DiretorRepository repository){
        this.repository = repository;
    }

    public List<Diretor> listar(){
        return repository.findAll();
    }

    public Diretor listarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Diretor não encontrado"));
    }

    public Diretor inserir(Diretor diretor){
        return repository.save(diretor);
    }

    public Diretor atualizar(Long id, Diretor diretorAtualizado){
        Diretor diretor = listarPorId(id);
        diretor.setNome(diretorAtualizado.getNome());
        diretor.setAtivo(diretorAtualizado.isAtivo());
        return repository.save(diretor);
    }

    public void deletar(Long id){
        Diretor diretor = listarPorId(id);
        diretor.setAtivo(!diretor.isAtivo());
        repository.save(diretor);
    }
}
