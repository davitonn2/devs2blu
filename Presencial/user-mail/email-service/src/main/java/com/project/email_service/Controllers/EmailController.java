package com.project.email_service.Controllers;

import com.project.email_service.Models.Email;
import com.project.email_service.Services.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public void mandarEmail(@RequestBody Email email) {
        emailService.enviar(email);
    }
}
