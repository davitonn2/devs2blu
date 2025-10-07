package com.example.funcionario.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class FuncionarioDTO {

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(max = 120)
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    @Email
    @Size(max = 60)
    private String email;


    @Size(max = 20)
    @Pattern(regexp = "^\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}$", message = "Telefone deve estar no formato (XX) XXXXX-XXXX")
    private String telefone;

    @Size(max = 60)
    @NotBlank(message = "Cargo é obrigatório")
    private String cargo;

    @NotBlank(message = "Salário é obrigatório")
    private Double salario;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}