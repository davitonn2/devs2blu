package com.example.Aula03.Controllers;

import com.example.Aula03.Models.Marca;
import com.example.Aula03.Services.MarcaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {
    public final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping
    public ResponseEntity<List<Marca>> pegarTodas(){
        return ResponseEntity.ok(marcaService.buscarTodos());
    }
    @PostMapping
    public ResponseEntity<Marca> criarMarca(@RequestBody Marca marca){
        return ResponseEntity.ok(marcaService.criar(marca));
    }
}