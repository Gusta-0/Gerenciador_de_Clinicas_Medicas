package com.gustavo.gerenciamento_clinicas_medicas.dto.response;

import com.gustavo.gerenciamento_clinicas_medicas.model.Usuario;

public record UsuarioResponseDTO(
        Long id,
        String nome,
        String email,
        Boolean ativo
) {
    public static UsuarioResponseDTO fromEntity(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Usuário não pode ser null");
        }

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getAtivo()
        );
    }
}