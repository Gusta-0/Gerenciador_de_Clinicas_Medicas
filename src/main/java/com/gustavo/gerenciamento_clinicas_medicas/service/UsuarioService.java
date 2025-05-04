package com.gustavo.gerenciamento_clinicas_medicas.service;

import com.gustavo.gerenciamento_clinicas_medicas.dto.request.UsuarioRequestDTO;
import com.gustavo.gerenciamento_clinicas_medicas.dto.response.UsuarioResponseDTO;
import com.gustavo.gerenciamento_clinicas_medicas.model.Usuario;
import com.gustavo.gerenciamento_clinicas_medicas.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Listar todos os usuários
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioResponseDTO::fromEntity)
                .toList();
    }

    // Buscar por ID
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        return UsuarioResponseDTO.fromEntity(usuario);
    }

    // Criar novo usuário
    public UsuarioResponseDTO criar(UsuarioRequestDTO dto) {
        if (usuarioRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("Já existe um usuário com esse e-mail.");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha()); // Sem criptografia, senha em texto simples
        usuario.setRole(dto.role());
        usuario.setAtivo(true);

        Usuario salvo = usuarioRepository.save(usuario);
        return UsuarioResponseDTO.fromEntity(salvo);
    }

    // Atualizar usuário existente
    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));

        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha()); // Sem criptografia, senha em texto simples
        usuario.setRole(dto.role());

        Usuario atualizado = usuarioRepository.save(usuario);
        return UsuarioResponseDTO.fromEntity(atualizado);
    }

    // Desativar usuário (soft delete)
    public void desativar(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
        usuario.setAtivo(false);
        usuarioRepository.save(usuario);
    }

    // Buscar por e-mail
    public UsuarioResponseDTO buscarPorEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com e-mail: " + email));
        return UsuarioResponseDTO.fromEntity(usuario);
    }

    // Buscar por status (ativo/inativo)
    public List<UsuarioResponseDTO> buscarPorAtivo(boolean ativo) {
        return usuarioRepository.findByAtivo(ativo).stream()
                .map(UsuarioResponseDTO::fromEntity)
                .toList();
    }
}


