package com.example.aula04.Services;

import com.example.aula04.Models.Artista;
import com.example.aula04.Models.Diretor;
import com.example.aula04.Repositories.ArtistaRepository;
import com.example.aula04.Repositories.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiretorService {

    private final DiretorRepository diretorRepository;

    public DiretorService(DiretorRepository diretorRepository) {
        this.diretorRepository = diretorRepository;
    }

    public List<Diretor> buscarTodos() {
        return diretorRepository.findAll();
    }

    public Diretor criar (Diretor diretor) {
        return diretorRepository.save(diretor);
    }

    public Diretor acharPorNacionalidade(String nacionalidade) {
        return diretorRepository.findByNacionalidade(nacionalidade);
    }
}
