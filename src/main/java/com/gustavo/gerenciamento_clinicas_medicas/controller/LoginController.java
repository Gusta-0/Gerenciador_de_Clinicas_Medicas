package com.gustavo.gerenciamento_clinicas_medicas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // vai procurar login.html em /templates
    }
}