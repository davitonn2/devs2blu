package com.example.aula04.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Diretor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String nacionalidade;

    @ManyToMany
    @JoinTable(
            name = "diretores_premio",
            joinColumns = @JoinColumn(name = "diretor_id"),
            inverseJoinColumns = @JoinColumn(name = "premio_id")
    )
    private List<Premio> premios;
}
