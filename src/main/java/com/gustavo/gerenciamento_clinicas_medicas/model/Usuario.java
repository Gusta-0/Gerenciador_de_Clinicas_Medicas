package com.gustavo.gerenciamento_clinicas_medicas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Schema(example = "Daniel de Souza", requiredMode = Schema.RequiredMode.REQUIRED, description = "Nome do usuário")
    private String nome;

    @NotBlank
    @Column(unique = true)
    @Email(message = "O campo [email] deve conter um e-mail válido")
    @Schema(example = "DanielCoelho2@gmail.com", requiredMode = Schema.RequiredMode.REQUIRED, description = "E-mail do usuário")
    private String email;

    @NotBlank
    @Schema(example = "Luca5C0elh0@", requiredMode = Schema.RequiredMode.REQUIRED, description = "Senha do usuário")
    private String senha;

    @Enumerated(EnumType.STRING)
    private Role role;

    private Boolean ativo = true;

    public enum TipoUsuario {
        ADMIN, MEDICO, PACIENTE
    }

    public enum Role {
        ADMIN,
        MEDICO,
        RECEPCIONISTA,
        PACIENTE
    }

}
