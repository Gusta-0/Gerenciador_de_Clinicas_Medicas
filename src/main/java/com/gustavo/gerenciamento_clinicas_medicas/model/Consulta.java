package com.gustavo.gerenciamento_clinicas_medicas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false)
    @Schema(example = "Daniel de Souza", requiredMode = Schema.RequiredMode.REQUIRED, description = "Nome do paciente")
    private Paciente paciente;

    @Future
    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private StatusConsulta status;

    @Schema(example = "Detalhes da consulta", requiredMode = Schema.RequiredMode.REQUIRED, description = "Ex: Parecer médico sobre resultados de exames")
    private String observacoes;

    public enum StatusConsulta {
        AGENDADA, CONFIRMADA, CANCELADA, REALIZADA
    }
}
