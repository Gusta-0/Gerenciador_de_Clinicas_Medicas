package com.gustavo.gerenciamento_clinicas_medicas.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Status", description = "Verificando se a api está rodando")
public class StatusController {

    @GetMapping("/status")

    public String ping() {
        return "pong";
    }
}
