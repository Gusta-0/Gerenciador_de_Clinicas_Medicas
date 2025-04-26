package com.gustavo.gerenciamento_clinicas_medicas.dto.response;

import com.gustavo.gerenciamento_clinicas_medicas.model.Consulta;

import java.time.LocalDateTime;

public record ConsultaResponse(
        Long id,
        Long medicoId,
        String medicoNome,
        Long pacienteId,
        String pacienteNome,
        LocalDateTime dataHora,
        String status,
        String observacoes
) {
    public static ConsultaResponse fromEntity(Consulta consulta) {
        return new ConsultaResponse(
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
