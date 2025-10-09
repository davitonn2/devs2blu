package com.example.demo.Controllers;

import com.example.demo.model.Produto;
import com.example.demo.services.ProdutoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<Page<Produto>> getAll(
            @RequestParam(required = false) String categoria,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) Double precoMin,
            @RequestParam(required = false) String cor,
            Pageable pageable
    ){

        return ResponseEntity.ok(produtoService.getAll(categoria, marca, precoMin, cor, pageable));
    }


}