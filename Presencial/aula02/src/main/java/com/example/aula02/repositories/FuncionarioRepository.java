package com.example.aula02.repositories;

import com.example.aula02.models.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    List<Funcionario> findByCidadeIgnoreCase(String cidade);

    List<Funcionario> findBySalarioGreaterThan(Double salario);

    List<Funcionario> findByEmailContaining(String email);

    List<Funcionario> findBySalarioBetween(Double min, Double max);

}
