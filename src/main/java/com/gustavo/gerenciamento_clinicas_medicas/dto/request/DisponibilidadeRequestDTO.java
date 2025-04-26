package com.gustavo.gerenciamento_clinicas_medicas.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record DisponibilidadeRequest(
        @NotNull(message = "ID do médico é obrigatório")
        Long medicoId,

        @NotNull(message = "Dia da semana é obrigatório")
        DayOfWeek diaSemana,

        @NotNull(message = "Hora de início é obrigatória")
        LocalTime horaInicio,

        @NotNull(message = "Hora de fim é obrigatória")
        LocalTime horaFim,

        boolean disponivel
) {
    public DisponibilidadeRequest {
        if (horaInicio != null && horaFim != null && horaInicio.isAfter(horaFim)) {
            throw new IllegalArgumentException("Hora de início deve ser antes da hora de fim");
        }
    }
}
