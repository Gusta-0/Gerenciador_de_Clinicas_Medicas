package com.gustavo.gerenciamento_clinicas_medicas.secutity;

import org.springframework.ui.Model;
import com.gustavo.gerenciamento_clinicas_medicas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ForgotPasswordController {
    @Autowired
    private UserService userService; // Serviço que gerencia usuários

    @GetMapping("/esqueci-senha")
    public String showForgotPasswordPage() {
        return "forgot-password"; // Retorna a página onde o usuário vai informar o e-mail
    }

    @PostMapping("/esqueci-senha")
    public String processForgotPassword(@RequestParam String email, Model model) {
        boolean isEmailSent = userService.sendPasswordResetLink(email); // Envia o link de recuperação

        if (isEmailSent) {
            model.addAttribute("message", "Link de recuperação enviado para o seu e-mail.");
            return "login"; // Retorna para a página de login após enviar o link
        } else {
            model.addAttribute("error", "E-mail não encontrado.");
            return "forgot-password"; // Retorna à página de "Esqueci minha senha" com erro
        }
    }
}
