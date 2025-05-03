package com.gustavo.gerenciamento_clinicas_medicas.dto.response;

import com.gustavo.gerenciamento_clinicas_medicas.model.Consulta;
import com.gustavo.gerenciamento_clinicas_medicas.model.Disponibilidade;
import com.gustavo.gerenciamento_clinicas_medicas.model.Medico;
import jakarta.validation.constraints.NotBlank;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public record MedicoResponseDTO(
        Long id,
        @NotBlank String crm,
        @NotBlank String especialidade,
        @NotBlank String nome,
        @NotBlank String email,
        List<DisponibilidadeResumidaResponse> disponibilidades,
        List<ConsultaResumidaResponse> consultas,
        long totalConsultas,
        String status
) {
    public static MedicoResponseDTO fromEntity(Medico medico) {
        if (medico == null) {
            throw new IllegalArgumentException("Médico não pode ser null");
        }

        List<DisponibilidadeResumidaResponse> disponibilidades = Optional.ofNullable(medico.getDisponibilidades())
                .map(list -> list.stream()
                        .map(DisponibilidadeResumidaResponse::fromEntity)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());

        List<ConsultaResumidaResponse> consultas = Optional.ofNullable(medico.getConsultas())
                .map(list -> list.stream()
                        .map(ConsultaResumidaResponse::fromEntity)
                        .collect(Collectors.toList()))
                .orElse(Collections.emptyList());

        return new MedicoResponseDTO(
                medico.getId(),
                medico.getCrm(),
                medico.getEspecialidade(),
                medico.getNome(),
                medico.getEmail(),
                disponibilidades,
                consultas,
                consultas.size(),
                determinarStatusMedico(disponibilidades)
        );
    }

    private static String determinarStatusMedico(List<DisponibilidadeResumidaResponse> disponibilidades) {
        return disponibilidades.isEmpty() ? "INATIVO" : "ATIVO";
    }

    // Records internos

    public record DisponibilidadeResumidaResponse(
            Long id,
            String diaSemana,
            String horario
    ) {
        public static DisponibilidadeResumidaResponse fromEntity(Disponibilidade d) {
            return new DisponibilidadeResumidaResponse(
                    d.getId(),
                    d.getDiaSemana().name(),
                    d.getHoraInicio() + " às " + d.getHoraFim()
            );
        }
    }

    public record ConsultaResumidaResponse(
            Long id,
            String dataHora,
            String status
    ) {
        public static ConsultaResumidaResponse fromEntity(Consulta c) {
            return new ConsultaResumidaResponse(
                    c.getId(),
                    c.getDataHora().toString(),
                    c.getStatus().name()
            );
        }
    }
}
