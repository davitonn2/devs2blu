package com.example.Aula03.Controllers;

import com.example.Aula03.Models.Loja;
import com.example.Aula03.Services.LojaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lojas")
public class LojaController {

    private final LojaService lojaService;

    public LojaController(LojaService lojaService) {
        this.lojaService = lojaService;
    }

    @PostMapping
    public ResponseEntity<Loja> criarLoja(@RequestBody Loja loja) {
        Loja novaLoja = lojaService.criar(loja);
        return ResponseEntity.ok(novaLoja);
    }

    @GetMapping
    public ResponseEntity<List<Loja>> listarTodasAsLojas() {
        List<Loja> lojas = lojaService.listarTodas();
        return ResponseEntity.ok(lojas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loja> buscarLojaPorId(@PathVariable Long id) {
        Loja loja = lojaService.buscarPorId(id);
        if (loja != null) {
            return ResponseEntity.ok(loja);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Loja> atualizarLoja(@PathVariable Long id, @RequestBody Loja loja) {
        Loja lojaAtualizada = lojaService.atualizar(id, loja);
        if (lojaAtualizada != null) {
            return ResponseEntity.ok(lojaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLoja(@PathVariable Long id) {
        lojaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}