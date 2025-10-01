package com.example.Aula03.Services;

import com.example.Aula03.Models.Marca;
import com.example.Aula03.Repositories.MarcaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MarcaService {
    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    @Transactional(readOnly = true)
    public List<Marca> buscarTodos(){
        return marcaRepository.findAll();
    }

    public Marca criar(Marca marca){
        return marcaRepository.save(marca);
    }
}