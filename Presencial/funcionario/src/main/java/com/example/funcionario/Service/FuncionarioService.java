package com.example.funcionario.Service;

import com.example.funcionario.DTO.FuncionarioDTO;

import java.util.List;

public interface FuncionarioService {
    FuncionarioDTO criar(FuncionarioDTO dto);
    FuncionarioDTO atualizar1(Long id, FuncionarioDTO dto);
    FuncionarioDTO buscarPorId(Long id);
    List<FuncionarioDTO> listarTodos();
    void deletar(Long id);
    FuncionarioDTO atualizarFuncionario(Long id, FuncionarioDTO dto);
    FuncionarioDTO mudarCargo(Long id, String novoCargo, Double novoSalario);
}
