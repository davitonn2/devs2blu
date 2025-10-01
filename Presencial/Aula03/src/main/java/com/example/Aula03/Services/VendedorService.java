package com.example.Aula03.Services;

import com.example.Aula03.Models.Loja;
import com.example.Aula03.Models.Vendedor;
import com.example.Aula03.Repositories.VendedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendedorService {

    private final VendedorRepository vendedorRepository;

    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }


    public Vendedor criar(Vendedor vendedor) {
        return vendedorRepository.save(vendedor);
    }

    public List<Vendedor> listarTodas() {
        return vendedorRepository.findAll();
    }

    public Vendedor buscarPorId(Long id) {
        Optional<Vendedor> vendedorOptional = vendedorRepository.findById(id);
        return vendedorOptional.orElse(null);
    }
    public List<Vendedor> buscarPorLoja(Long id) {
        return vendedorRepository.findByLojaId(id);
    }

    public Vendedor atualizar(Long id, Vendedor vendedorAtualizado) {
        Optional<Vendedor> vendedorExistenteOptional = vendedorRepository.findById(id);

        if (vendedorExistenteOptional.isPresent()) {
            Vendedor vendedorExistente = vendedorExistenteOptional.get();

            vendedorExistente.setNome(vendedorAtualizado.getNome());

            return vendedorRepository.save(vendedorExistente);
        } else {
            return null;
        }
    }

    public void deletar(Long id) {
        vendedorRepository.deleteById(id);
    }

}
