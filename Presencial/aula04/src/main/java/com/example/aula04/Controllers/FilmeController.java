package com.example.aula04.Controllers;

import com.example.aula04.Models.Artista;
import com.example.aula04.Models.Filme;
import com.example.aula04.Services.ArtistaService;
import com.example.aula04.Services.FilmeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/filmes")
public class FilmeController {

    private final FilmeService filmeService;

    public FilmeController(FilmeService filmeService1) {
        this.filmeService = filmeService1;
    }

    @GetMapping
    public ResponseEntity<List<Filme>> buscarTodos() {
        return ResponseEntity.ok(filmeService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Filme> adicionar(@RequestBody Filme filme) {
        return ResponseEntity.ok(filmeService.criar(filme));
    }
}
