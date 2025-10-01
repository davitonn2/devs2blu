package com.example.Aula03.Services;

import com.example.Aula03.Models.Loja;
import com.example.Aula03.Repositories.LojaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LojaService {

    private final LojaRepository lojaRepository;

    public LojaService(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    public Loja criar(Loja loja) {
        return lojaRepository.save(loja);
    }

    public List<Loja> listarTodas() {
        return lojaRepository.findAll();
    }

    public Loja buscarPorId(Long id) {
        Optional<Loja> lojaOptional = lojaRepository.findById(id);
        return lojaOptional.orElse(null);
    }

    public Loja atualizar(Long id, Loja lojaAtualizada) {
        // 1. Busca a loja no banco de dados pelo ID
        Optional<Loja> lojaExistenteOptional = lojaRepository.findById(id);

        // 2. Verifica se a loja foi encontrada
        if (lojaExistenteOptional.isPresent()) {
            Loja lojaExistente = lojaExistenteOptional.get();

            // 3. Atualiza os campos da loja existente com os dados recebidos
            lojaExistente.setNome(lojaAtualizada.getNome());
            // (Você pode adicionar outros campos para atualizar aqui)

            // 4. Salva a loja atualizada de volta no banco
            return lojaRepository.save(lojaExistente);
        } else {
            // 5. Retorna null se a loja não for encontrada
            return null;
        }
    }

    public void deletar(Long id) {
        lojaRepository.deleteById(id);
    }
}
