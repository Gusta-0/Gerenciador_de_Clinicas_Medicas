package com.gustavo.gerenciamento_clinicas_medicas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Paciente extends Usuario {
    @NotBlank
    @Column(unique = true)
    @Schema(example = "000.000.000.99", requiredMode = Schema.RequiredMode.REQUIRED, description = "Cpf do paciente")
    private String cpf;

    @Past
    @Schema(example = "2000-01-01", requiredMode = Schema.RequiredMode.REQUIRED, description = "Data de nascimento do paciente")
    private LocalDate dataNascimento;

    @Schema(example = "99 99999-9999", requiredMode = Schema.RequiredMode.REQUIRED, description = "Celular do paciente")
    private String telefone;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Consulta> consultas = new ArrayList<>();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "cep", column = @Column(name = "cep")),
            @AttributeOverride(name = "logradouro", column = @Column(name = "logradouro")),
            @AttributeOverride(name = "numero", column = @Column(name = "numero")),
            @AttributeOverride(name = "complemento", column = @Column(name = "complemento")),
            @AttributeOverride(name = "bairro", column = @Column(name = "bairro")),
            @AttributeOverride(name = "cidade", column = @Column(name = "cidade")),
            @AttributeOverride(name = "estado", column = @Column(name = "estado"))
    })
    private Endereco endereco;
}
