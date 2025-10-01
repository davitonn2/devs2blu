package com.example.Aula03.Controllers;

import com.example.Aula03.Models.Loja;
import com.example.Aula03.Models.Vendedor;
import com.example.Aula03.Services.LojaService;
import com.example.Aula03.Services.VendedorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendedores")
public class VendedorController {

    private final VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @PostMapping
    public ResponseEntity<Vendedor> criarVendedor(@RequestBody Vendedor vendedor) {
        Vendedor novoVendedor = vendedorService.criar(vendedor);
        return ResponseEntity.ok(novoVendedor);
    }

    @GetMapping
    public ResponseEntity<List<Vendedor>> listarTodosVendedores() {
        List<Vendedor> vendedores = vendedorService.listarTodas();
        return ResponseEntity.ok(vendedores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> buscarVendedorPorId(@PathVariable Long id) {
        Vendedor vendedor = vendedorService.buscarPorId(id);
        if (vendedor != null) {
            return ResponseEntity.ok(vendedor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendedor> atualizarVendedor(@PathVariable Long id, @RequestBody Vendedor vendedor) {
        Vendedor vendedorAtualizado = vendedorService.atualizar(id, vendedor);
        if (vendedorAtualizado != null) {
            return ResponseEntity.ok(vendedorAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVendedor(@PathVariable Long id) {
        vendedorService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}