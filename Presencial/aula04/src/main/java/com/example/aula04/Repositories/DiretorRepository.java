package com.example.aula04.Repositories;

import com.example.aula04.Models.Artista;
import com.example.aula04.Models.Diretor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DiretorRepository extends JpaRepository<Diretor, Long> {
    Diretor findByNacionalidade(String nacionalidade);
}
