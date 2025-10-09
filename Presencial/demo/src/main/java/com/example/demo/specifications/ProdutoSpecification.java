package com.example.demo.specifications;

import com.example.demo.model.Produto;
import org.springframework.data.jpa.domain.Specification;


import com.example.demo.model.Produto;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate; // Importe o Predicate

import java.util.ArrayList;
import java.util.List;

public class ProdutoSpecification {
    public static Specification<Produto> comFiltros(String categoria, String marca, Double precoMin, String cor){

        return (root, query, cb) -> {

            List<Predicate> predicates = new ArrayList<>();

            if(categoria != null && !categoria.isBlank()){ //
                predicates.add(
                        cb.equal(cb.lower(root.get("categoria")), categoria.toLowerCase())
                );
                System.out.println("Filtro Categoria Ativo: " + categoria);
            }

            if(marca != null && !marca.isBlank()){
                predicates.add(
                        cb.equal(cb.lower(root.get("marca")), marca.toLowerCase())
                );
                System.out.println("Filtro Marca Ativo: " + marca);
            }

            if(cor != null && !cor.isBlank()){
                predicates.add(
                        cb.equal(cb.lower(root.get("cor")), cor.toLowerCase())
                );
                System.out.println("Filtro Marca Ativo: " + marca);
            }

            if(precoMin != null){
                predicates.add(cb.greaterThanOrEqualTo(
                        root.get("preco"), precoMin)
                );
                System.out.println("Filtro Preço Mínimo Ativo: " + precoMin);
            }


            if (predicates.isEmpty()) {
                return null;
            } else {
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}