package com.gustavo.gerenciamento_clinicas_medicas.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record MedicoRequestDTO(
        @NotBlank(message = "CRM é obrigatório")
        @Pattern(regexp = "\\d{4,10}[A-Za-z]?", message = "CRM deve conter de 4 a 10 dígitos, podendo ter letras")
        @Schema(example = ("1234567890A"), description = "CRM deve conter de 4 a 10 dígitos, podendo ter letras")
        String crm,

        @NotBlank(message = "Especialidade é obrigatória")
        @Schema(example = "Cardiologia", description = "Especialidade do médico")
        String especialidade,

        @NotBlank(message = "Nome é obrigatório")
        @Schema(example = "Dr. João da Silva", description = "Nome completo do médico")
        String nome,

        @NotBlank(message = "Email é obrigatório")
        @Schema(example = "CardiologistaSilva12@gmail.com", description = "Email do médico")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        String senha,

        List<Long> disponibilidadesIds
) {}
