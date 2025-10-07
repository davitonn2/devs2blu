package com.example.funcionario.Service;

import com.example.funcionario.DTO.FuncionarioDTO;
import com.example.funcionario.Model.Funcionario;
import com.example.funcionario.Repository.FuncionarioRepository;
import com.example.funcionario.execptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class FuncionarioServiceImpl implements FuncionarioService{

    private final FuncionarioRepository repository;

    public FuncionarioServiceImpl(FuncionarioRepository repository) {
        this.repository = repository;
    }

    private FuncionarioDTO toDto(Funcionario f){
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(f.getId());
        dto.setNome(f.getNome());
        dto.setEmail(f.getEmail());
        dto.setTelefone(f.getTelefone());
        dto.setCargo(f.getCargo());
        dto.setSalario(f.getSalario());
        return dto;
    }

    private Funcionario toEntity(FuncionarioDTO dto){
        Funcionario f = new Funcionario();
        f.setNome(dto.getNome());
        f.setEmail(dto.getEmail());
        f.setTelefone(dto.getTelefone());
        f.setCargo(dto.getCargo());
        f.setSalario(dto.getSalario());
        return f;
    }

    public FuncionarioDTO criar(FuncionarioDTO dto) {
        if(repository.existsByEmail(dto.getEmail())){
            throw new IllegalArgumentException("Email já cadastrado");
        }
        Funcionario f =  toEntity(dto);
        Funcionario salvo =  repository.save(f);
        return toDto(salvo);
    }

    public FuncionarioDTO atualizar1(Long id, FuncionarioDTO dto) {
        return null;
    }

    @Transactional(readOnly = true)
    public FuncionarioDTO buscarPorId(Long id) {
        Optional<Funcionario> optional = repository.findById(id);
        if (optional.isEmpty()) {
            throw new ResourceNotFoundException("Funcionário não encontrado com ID: " + id);
        }
        return toDto(optional.get());
    }

    @Transactional(readOnly = true)
    public List<FuncionarioDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public void deletar(Long id) {
        if(!repository.existsById(id)){
            throw  new ResourceNotFoundException("Pagante não encontrado com o id " +id);
        }
        repository.deleteById(id);
    }

    public FuncionarioDTO atualizarFuncionario(Long id, FuncionarioDTO dto) {
        Funcionario f = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));

        f.setNome(dto.getNome());
        f.setEmail(dto.getEmail());
        f.setTelefone(dto.getTelefone());
        f.setCargo(dto.getCargo());
        f.setSalario(dto.getSalario());

        return toDto(repository.save(f));
    }

    @Transactional
    public FuncionarioDTO mudarCargo(Long id, String novoCargo, Double novoSalario) {
        Funcionario f = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Funcionário não encontrado"));

        f.setCargo(novoCargo);
        f.setSalario(novoSalario);
        return toDto(repository.save(f));
    }

}
