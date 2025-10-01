package com.example.aula02.controllers;

import com.example.aula02.models.Funcionario;
import com.example.aula02.services.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> getAll() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Funcionario> add(@RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(service.criarNovo(funcionario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Funcionario> funcionario = service.buscarPorId(id);
        if(funcionario.isEmpty()) {
            return ResponseEntity.ok("Funcionario nao encontrado");
        }
        return ResponseEntity.ok(funcionario.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<Funcionario>> getByCidade(@PathVariable String cidade) {
        return ResponseEntity.ok(service.getByCidadeIgnoreCase(cidade));
    }
}
