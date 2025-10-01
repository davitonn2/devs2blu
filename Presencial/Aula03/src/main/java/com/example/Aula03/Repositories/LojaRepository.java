package com.example.Aula03.Repositories;

import com.example.Aula03.Models.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Long> {

}
