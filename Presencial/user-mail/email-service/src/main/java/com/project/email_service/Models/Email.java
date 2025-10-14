package com.project.email_service.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Email {
    private String destinatario;
    private String assunto;
    private String corpo;
    private Long user_Id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Email() {
    }

    public Email(String destinatario, String assunto, String corpo, Long user_Id) {
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.corpo = corpo;
        this.user_Id = user_Id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public Long getUserId() {
        return user_Id;
    }

    public void setUserId(Long userId) {
        this.user_Id = user_Id;
    }
}
