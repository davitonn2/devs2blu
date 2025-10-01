package com.example.aula02.controllers;

import com.example.aula02.models.Funcionario;
import com.example.aula02.models.Setor;
import com.example.aula02.services.SetorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/setor")
public class SetorController {

    private final SetorService setorService;

    public SetorController(SetorService setorService) {
        this.setorService = setorService;
    }

    @GetMapping
    public ResponseEntity<List<Setor>> getAll() {
        return ResponseEntity.ok(setorService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Setor> add(@RequestBody Setor setor) {
        return ResponseEntity.ok(setorService.criarNovo(setor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Setor> setor = setorService.buscarPorId(id);
        if(setor.isEmpty()) {
            return ResponseEntity.ok("Setor nao encontrado");
        }
        return ResponseEntity.ok(setor.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(setorService.delete(id));
    }
}
