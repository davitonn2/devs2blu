package com.example.aula04.Services;

import com.example.aula04.Models.Artista;
import com.example.aula04.Models.Filme;
import com.example.aula04.Repositories.ArtistaRepository;
import com.example.aula04.Repositories.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public List<Filme> buscarTodos() {
        return filmeRepository.findAll();
    }

    public Filme criar (Filme filme) {
        return filmeRepository.save(filme);
    }
}
