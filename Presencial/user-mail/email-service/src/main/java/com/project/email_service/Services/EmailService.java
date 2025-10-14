package com.project.email_service.Services;

import com.project.email_service.Models.Email;
import com.project.email_service.Repositories.EmailRepository;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final EmailRepository emailRepository;

    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }

    public Email enviar(Email email) {
        System.out.println("[emailService] EMAIL ENVIADO para: " + email.getDestinatario());
        return emailRepository.save(email);
    }
}
