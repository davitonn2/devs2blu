package com.example.aula04.Controllers;

import com.example.aula04.Models.Artista;
import com.example.aula04.Models.Diretor;
import com.example.aula04.Services.ArtistaService;
import com.example.aula04.Services.DiretorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diretores")
public class DiretorController {

    private final DiretorService diretorService;

    public DiretorController(DiretorService diretorService) {
        this.diretorService = diretorService;
    }

    @GetMapping
    public ResponseEntity<List<Diretor>> buscarTodos() {
        return ResponseEntity.ok(diretorService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Diretor> adicionar(@RequestBody Diretor diretor) {
        return ResponseEntity.ok(diretorService.criar(diretor));
    }

    @GetMapping("/nacionalidade/{nacionalidade}")
    public ResponseEntity<Diretor> acharPorNacionalidade(@PathVariable String nacionalidade) {
        return ResponseEntity.ok(diretorService.acharPorNacionalidade(nacionalidade));
    }
}
