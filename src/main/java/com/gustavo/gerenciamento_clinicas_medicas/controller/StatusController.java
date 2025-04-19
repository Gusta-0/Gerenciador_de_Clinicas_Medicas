package com.gustavo.gerenciamento_clinicas_medicas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {

    @GetMapping
    public String ping(){
     return "pong";
    }
}
