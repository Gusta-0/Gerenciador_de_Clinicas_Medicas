package com.gustavo.gerenciamento_clinicas_medicas.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record MedicoRequestDTO(
        @NotBlank(message = "CRM é obrigatório")
        @Pattern(regexp = "\\d{4,10}[A-Za-z]?", message = "CRM deve conter de 4 a 10 dígitos, podendo ter letras")
        String crm,

        @NotBlank(message = "Especialidade é obrigatória")
        String especialidade,

        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "Email é obrigatório")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        String senha,

        List<Long> disponibilidadesIds
) {}
