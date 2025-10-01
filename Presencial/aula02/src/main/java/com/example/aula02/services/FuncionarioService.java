package com.example.aula02.services;

import com.example.aula02.models.Funcionario;
import com.example.aula02.repositories.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {
    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.repository = funcionarioRepository;
    }

    public List<Funcionario> buscarTodos() {
        return repository.findAll();
    }

    public Funcionario criarNovo(Funcionario funcionario) {
        return repository.save(funcionario);
    }

    public Optional<Funcionario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public String delete(Long id) {
        Optional<Funcionario> funcionario = buscarPorId(id);
        if(funcionario.isEmpty()) {
            return "Funcionario não encontrado!";
        }
        repository.delete(funcionario.get());
        return "Funcionario excluido com Reginaldo.";
    }

    public List<Funcionario> getByCidadeIgnoreCase(String cidade) {
        return repository.findByCidadeIgnoreCase(cidade);
    }


}
