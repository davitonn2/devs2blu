package com.project.user_service.DTOs;

public class EmailDTO {
    private String destinario;
    private String assunto;
    private String corpo;
    private Long userId;

    public EmailDTO(String destinario, String assunto, String corpo, Long userId) {
        this.destinario = destinario;
        this.assunto = assunto;
        this.corpo = corpo;
    }

    public EmailDTO() {
    }

    public String getDestinario() {
        return destinario;
    }

    public void setDestinario(String destinario) {
        this.destinario = destinario;
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
}
