package com.gustavo.gerenciamento_clinicas_medicas.dto.response;

import com.gustavo.gerenciamento_clinicas_medicas.model.Disponibilidade;

import java.time.DayOfWeek;
import java.time.LocalTime;

public record DisponibilidadeResponseDTO(
        Long id,
        Long medicoId,
        String medicoNome,
        DayOfWeek diaSemana,
        LocalTime horaInicio,
        LocalTime horaFim,
        boolean disponivel
) {
    public static DisponibilidadeResponseDTO fromEntity(Disponibilidade disponibilidade) {
        return new DisponibilidadeResponseDTO(
                disponibilidade.getId(),
                disponibilidade.getMedico().getId(),
                disponibilidade.getMedico().getNome(),
                disponibilidade.getDiaSemana(),
                disponibilidade.getHoraInicio(),
                disponibilidade.getHoraFim(),
                disponibilidade.isDisponivel()
        );
    }
}