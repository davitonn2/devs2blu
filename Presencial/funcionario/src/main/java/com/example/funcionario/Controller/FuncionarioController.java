package com.example.funcionario.Controller;

import com.example.funcionario.DTO.FuncionarioDTO;
import com.example.funcionario.Service.FuncionarioService;
import com.example.funcionario.execptions.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioDTO>> listarTodos(){
        return ResponseEntity.ok(funcionarioService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            FuncionarioDTO funcionario = funcionarioService.buscarPorId(id);
            return ResponseEntity.ok(funcionario);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<FuncionarioDTO> criar(@Valid @RequestBody FuncionarioDTO dto){
        FuncionarioDTO criado =  funcionarioService.criar(dto);

        return ResponseEntity.created(URI.create("/api/funcionarios/" + criado.getId())).body(criado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        funcionarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarFunc(@PathVariable Long id, @Valid @RequestBody FuncionarioDTO dto) {
        try {
            FuncionarioDTO atualizado = funcionarioService.atualizarFuncionario(id, dto);
            return ResponseEntity.ok(atualizado);
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PatchMapping("/{id}/cargo")
    public ResponseEntity<?> mudarCargo(@PathVariable Long id, @RequestBody Map<String, Object> payload) {
        try {
            String novoCargo = (String) payload.get("cargo");
            Double novoSalario = null;

            if (payload.get("salario") != null) {
                novoSalario = Double.parseDouble(payload.get("salario").toString());
            }

            if (novoCargo == null || novoCargo.isBlank()) {
                return ResponseEntity.badRequest().body("O novo cargo é obrigatório.");
            }

            FuncionarioDTO atualizado = funcionarioService.mudarCargo(id, novoCargo, novoSalario);
            return ResponseEntity.ok(atualizado);

        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar cargo e salário: " + e.getMessage());
        }
    }
}
