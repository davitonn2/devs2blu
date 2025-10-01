package com.projetos.primeira_api.controllers;

import com.projetos.primeira_api.models.Pais;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("pais")
public class PaisController {
    private static List<Pais> paises = new ArrayList<>();

    @GetMapping
    public List<Pais> getAll() {
        return paises;
    }

    @PostMapping
    public String add(@RequestBody Pais pais) {
        paises.add(pais);
        return "Pais criado com sucesso!";
    }

}
