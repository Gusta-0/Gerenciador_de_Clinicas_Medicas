package com.gustavo.gerenciamento_clinicas_medicas.controller;

import com.gustavo.gerenciamento_clinicas_medicas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class LoginController {

    @Autowired
    private UserService userService; // Serviço para validar o login

    @GetMapping("/login")
    public String showLoginPage() {
        return "login"; // Retorna a página de login
    }
//
//    @PostMapping("/login")
//    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
//        User user = userService.validateUser(username, password);
//
//        if (user != null) {
//            model.addAttribute("user", user); // Armazena o usuário na sessão
//            return "redirect:/home"; // Redireciona para a página inicial
//        } else {
//            model.addAttribute("error", "Usuário ou senha inválidos");
//            return "login"; // Retorna à página de login com mensagem de erro
//        }
//    }
}