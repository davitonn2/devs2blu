package com.example.aula04.Services;

import com.example.aula04.Models.Artista;
import com.example.aula04.Models.Diretor;
import com.example.aula04.Models.Premio;
import com.example.aula04.Repositories.ArtistaRepository;
import com.example.aula04.Repositories.DiretorRepository;
import com.example.aula04.Repositories.PremioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PremioService {

    private final PremioRepository premioRepository;

    public PremioService(PremioRepository premioRepository) {
        this.premioRepository = premioRepository;
    }

    public List<Premio> buscarTodos() {
        return premioRepository.findAll();
    }

    public Premio criar (Premio premio) {
        return premioRepository.save(premio);
    }

    public Premio acharPorNomeDoPremio(String nomeDoPremio) {
        return premioRepository.findByNomeDoPremio(nomeDoPremio);
    }
}
