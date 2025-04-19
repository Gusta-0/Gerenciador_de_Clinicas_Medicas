package com.gustavo.gerenciamento_clinicas_medicas.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ConsultaRequest(
        @NotNull(message = "ID do médico é obrigatório")
        Long medicoId,

        @NotNull(message = "ID do paciente é obrigatório")
        Long pacienteId,

        @Future(message = "A data/hora deve ser no futuro")
        @NotNull(message = "Data/hora é obrigatória")
        LocalDateTime dataHora,

        String observacoes
) {}
