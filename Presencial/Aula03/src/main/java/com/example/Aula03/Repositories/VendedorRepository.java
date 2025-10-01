package com.example.Aula03.Repositories;

import com.example.Aula03.Models.Loja;
import com.example.Aula03.Models.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long> {
    List<Vendedor> findByLojaId(Long id);
}
