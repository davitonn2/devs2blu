package com.example.aula04.Repositories;

import com.example.aula04.Models.Artista;
import com.example.aula04.Models.Premio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PremioRepository extends JpaRepository<Premio, Long> {

    @Query("SELECT p FROM Premio p WHERE p.nome = :nomeDoPremio")
    Premio findByNomeDoPremio(@Param("nomeDoPremio") String nomeDoPremio);

}
