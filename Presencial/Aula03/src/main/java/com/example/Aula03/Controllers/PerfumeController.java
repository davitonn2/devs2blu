package com.example.Aula03.Controllers;

import com.example.Aula03.Models.Marca;
import com.example.Aula03.Models.Perfume;
import com.example.Aula03.Services.MarcaService;
import com.example.Aula03.Services.PerfumeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/perfumes")
public class PerfumeController {
    public final PerfumeService perfumeService;

    public PerfumeController(PerfumeService perfumeService) {
        this.perfumeService = perfumeService;
    }

    @GetMapping
    public ResponseEntity<List<Perfume>> pegarTodas(){
        return ResponseEntity.ok(perfumeService.buscarTodos());
    }
    @PostMapping
    public ResponseEntity<Perfume> criarMarca(@RequestBody Perfume perfume){
        return ResponseEntity.ok(perfumeService.criar(perfume));
    }

    @GetMapping("/marca/{id}")
    public ResponseEntity<List<Perfume>> pegarPorMarca(@PathVariable Long id) {
        return ResponseEntity.ok(perfumeService.buscarPorMarca(id));
    }
}