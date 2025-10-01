package com.example.aula02.services;

import com.example.aula02.models.Funcionario;
import com.example.aula02.models.Setor;
import com.example.aula02.repositories.SetorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SetorService {
    private final SetorRepository setorRepository;


    public SetorService(SetorRepository setorRepository) {
        this.setorRepository = setorRepository;
    }

    public List<Setor> buscarTodos() {
        return setorRepository.findAll();
    }

    public Setor criarNovo(Setor setor) {
        return setorRepository.save(setor);
    }

    public Optional<Setor> buscarPorId(Long id) {
        return setorRepository.findById(id);
    }

    public String delete(Long id) {
        Optional<Setor> setor = buscarPorId(id);
        if(setor.isEmpty()) {
            return "Setor não encontrado!";
        }
        setorRepository.delete(setor.get());
        return "Setor excluido com sucesso.";
    }
}
