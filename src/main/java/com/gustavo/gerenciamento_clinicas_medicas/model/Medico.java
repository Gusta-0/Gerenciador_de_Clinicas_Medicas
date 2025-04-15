package com.gustavo.gerenciamento_clinicas_medicas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Medico")
@Data
@EqualsAndHashCode(callSuper = true)
public class Medico extends Usuario {
    @NotBlank
    @Column(unique = true)
    private String crm;

    @NotBlank
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
