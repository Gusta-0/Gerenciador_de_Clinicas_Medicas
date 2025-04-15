package com.gustavo.gerenciamento_clinicas_medicas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Paciente")
@Data
@EqualsAndHashCode(callSuper = true)
public class Paciente extends Usuario {
    @NotBlank
    @Column(unique = true)
    private String cpf;

    @Past
    private LocalDate dataNascimento;

    private String telefone;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Consulta> consultas = new ArrayList<>();

    @Embedded
    private Endereco endereco;
}
