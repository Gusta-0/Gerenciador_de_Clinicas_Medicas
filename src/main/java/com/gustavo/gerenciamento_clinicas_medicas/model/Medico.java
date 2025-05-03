package com.gustavo.gerenciamento_clinicas_medicas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Medico extends Usuario {
    @NotBlank
    @Column(unique = true)
    @Schema(example = "CRM/RJ 789012", requiredMode = Schema.RequiredMode.REQUIRED, description = "CRM do médico")
    private String crm;

    @NotBlank
    @Schema(example = "Cardiologista", requiredMode = Schema.RequiredMode.REQUIRED, description = "Especialidade do médico")
    private String especialidade;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Disponibilidade> disponibilidades = new ArrayList<>();

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas = new ArrayList<>();

    public void adicionarDisponibilidade(Disponibilidade disponibilidade) {
        disponibilidades.add(disponibilidade);
        disponibilidade.setMedico(this);
    }

    public void removerDisponibilidade(Disponibilidade disponibilidade) {
        disponibilidades.remove(disponibilidade);
        disponibilidade.setMedico(null);
    }
}
