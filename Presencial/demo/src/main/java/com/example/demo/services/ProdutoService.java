package com.example.demo.services;

import com.example.demo.model.Produto;
import com.example.demo.repositories.ProdutoRepository;
import com.example.demo.specifications.ProdutoSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Page<Produto> getAll(String categoria, String marca, Double precoMin, String cor, Pageable pageable){

        var  spec = ProdutoSpecification.comFiltros(categoria, marca, precoMin, cor);

        return produtoRepository.findAll(spec, pageable);
    }
}