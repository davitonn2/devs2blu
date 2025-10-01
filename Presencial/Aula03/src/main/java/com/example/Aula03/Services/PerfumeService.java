package com.example.Aula03.Services;

import com.example.Aula03.Models.Marca;
import com.example.Aula03.Models.Perfume;
import com.example.Aula03.Repositories.PerfumeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class PerfumeService {
    private final PerfumeRepository perfumeRepository;

    public PerfumeService(PerfumeRepository perfumeRepository) {
        this.perfumeRepository = perfumeRepository;
    }

    public List<Perfume> buscarTodos(){
        return perfumeRepository.findAll();
    }
    public Perfume criar(Perfume perfume){
        return perfumeRepository.save(perfume);
    }
    public List<Perfume> buscarPorMarca(Long id) {
        return perfumeRepository.findByMarcaId(id);
    }
}