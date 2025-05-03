package com.gustavo.gerenciamento_clinicas_medicas.dto.response;

import com.gustavo.gerenciamento_clinicas_medicas.model.Consulta;

import java.time.LocalDateTime;

public record ConsultaResponseDTO(
        Long id,
        Long medicoId,
        String medicoNome,
        Long pacienteId,
        String pacienteNome,
        LocalDateTime dataHora,
        String status,
        String observacoes
) {
    public static ConsultaResponseDTO fromEntity(Consulta consulta) {
        return new ConsultaResponseDTO(
                consulta.getId(),
                consulta.getMedico().getId(),
                consulta.getMedico().getNome(),
                consulta.getPaciente().getId(),
                consulta.getPaciente().getNome(),
                consulta.getDataHora(),
                consulta.getStatus().name(),
                consulta.getObservacoes()
        );
    }
}
