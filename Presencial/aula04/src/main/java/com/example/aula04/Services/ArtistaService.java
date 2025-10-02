package com.example.aula04.Services;

import com.example.aula04.DTO.ArtistaDTO;
import com.example.aula04.Models.Artista;
import com.example.aula04.Repositories.ArtistaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistaService {

    private final ArtistaRepository artistaRepository;
    private final ObjectMapper objectMapper;

    public ArtistaService(ArtistaRepository artistaRepository, ObjectMapper objectMapper) {
        this.artistaRepository = artistaRepository;
        this.objectMapper = objectMapper;
    }

    public List<Artista> buscarTodos() {
        return artistaRepository.findAll();
    }

    public Artista criar (ArtistaDTO artistaDTO) {
        Artista artista = objectMapper.convertValue(artistaDTO, Artista.class);
        return artistaRepository.save(artista);
    }
}
