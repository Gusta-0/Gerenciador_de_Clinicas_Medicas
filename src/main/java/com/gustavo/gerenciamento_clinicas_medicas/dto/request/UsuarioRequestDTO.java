package com.gustavo.gerenciamento_clinicas_medicas.dto.request;

import com.gustavo.gerenciamento_clinicas_medicas.model.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import javax.management.relation.Role;

public record UsuarioRequestDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
        String senha,

        @NotNull(message = "Role é obrigatória")
        Usuario.Role role
) {

}
