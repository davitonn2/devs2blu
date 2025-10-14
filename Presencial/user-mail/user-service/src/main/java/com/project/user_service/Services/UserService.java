package com.project.user_service.Services;

import com.project.user_service.DTOs.EmailDTO;
import com.project.user_service.Models.User;
import com.project.user_service.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final WebClient webClientEmail;

    public UserService(UserRepository userRepository, WebClient webClient) {
        this.userRepository = userRepository;
        this.webClientEmail = webClient;
    }

    public User criarUser(User user) {
        User salvo = userRepository.save(user);
        EmailDTO email = new EmailDTO(
                salvo.getEmail(),
                "Bem Vindo(a) " + salvo.getNome(),
                "Seu cadastro foi realizado com sucessp!",
                salvo.getId()
        );
        webClientEmail.post()
                .uri("/email")
                .bodyValue(email)
                .retrieve()
                .bodyToMono(Void.class)
                .block();

        return salvo;
    }
}
