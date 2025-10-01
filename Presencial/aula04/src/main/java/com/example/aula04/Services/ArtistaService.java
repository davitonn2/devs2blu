package com.example.aula04.Services;

import com.example.aula04.Models.Artista;
import com.example.aula04.Repositories.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {

    private final ArtistaRepository artistaRepository;

    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

    public List<Artista> buscarTodos() {
        return artistaRepository.findAll();
    }

    public Artista criar (Artista artista) {
        return artistaRepository.save(artista);
    }
}
