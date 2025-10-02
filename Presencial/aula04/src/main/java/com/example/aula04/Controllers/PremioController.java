package com.example.aula04.Controllers;

import com.example.aula04.Models.Artista;
import com.example.aula04.Models.Premio;
import com.example.aula04.Services.ArtistaService;
import com.example.aula04.Services.PremioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/premios")
public class PremioController {

    private final PremioService premioService;

    public PremioController(PremioService premioService) {
        this.premioService = premioService;
    }

    @GetMapping
    public ResponseEntity<List<Premio>> buscarTodos() {
        return ResponseEntity.ok(premioService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Premio> adicionar(@RequestBody Premio premio) {
        return ResponseEntity.ok(premioService.criar(premio));
    }

    @GetMapping("/{nomeDoPremio}")
    public ResponseEntity<Premio> acharPremioPorNome(@PathVariable String nomeDoPremio) {
        return ResponseEntity.ok(premioService.acharPorNomeDoPremio(nomeDoPremio));
    }
}
