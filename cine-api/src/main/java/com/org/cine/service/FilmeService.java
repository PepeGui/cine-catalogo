package com.org.cine.service;

import com.org.cine.model.Diretor;
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

    public Filme listarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }

    public Filme inserir(Filme filme){
        return repository.save(filme);
    }

    public Filme atualizar(Long id, Filme filmeAtualizado){
        Filme filme = listarPorId(id);
        filme.setTitulo(filmeAtualizado.getTitulo());
        filme.setAnoLancamento(filmeAtualizado.getAnoLancamento());
        filme.setGenero(filmeAtualizado.getGenero());
        filme.setDiretor(new Diretor(
                filmeAtualizado.getDiretor().getId(),
                filmeAtualizado.getDiretor().getNome(),
                filmeAtualizado.getDiretor().isAtivo())
        );
        filme.setAtivo(filmeAtualizado.isAtivo());
        return repository.save(filme);
    }

    public void deletar(Long id){
        Filme filme = listarPorId(id);
        filme.setAtivo(!filme.isAtivo());
        repository.save(filme);
    }
}
