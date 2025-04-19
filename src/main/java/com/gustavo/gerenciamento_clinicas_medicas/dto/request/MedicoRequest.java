package com.gustavo.gerenciamento_clinicas_medicas.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public class MedicoRequest {
    @NotBlank(message = "CRM é obrigatório")
    @Pattern(regexp = "\\d{4,10}[A-Za-z]?", message = "CRM deve conter de 4 a 10 dígitos, podendo ter letras")
    String crm;

    @NotBlank(message = "Especialidade é obrigatória")
    String especialidade;

    // Campos herdados de Usuario
    @NotBlank String nome;
    @NotBlank String email;
    @NotBlank String senha;

    // Opcional: Lista de IDs de disponibilidades para vincular
    List<Long> disponibilidadesIds;
}
