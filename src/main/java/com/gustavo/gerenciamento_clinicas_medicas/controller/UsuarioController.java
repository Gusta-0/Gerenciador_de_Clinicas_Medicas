package com.gustavo.gerenciamento_clinicas_medicas.controller;

import com.gustavo.gerenciamento_clinicas_medicas.dto.request.UsuarioRequestDTO;
import com.gustavo.gerenciamento_clinicas_medicas.dto.response.UsuarioResponseDTO;
import com.gustavo.gerenciamento_clinicas_medicas.service.EnderecoMapper.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(name = "Usuário", description = "Gerenciamento de usuários")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/{id}")
    public UsuarioResponseDTO buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criar(@RequestBody @Valid UsuarioRequestDTO dto) {
        UsuarioResponseDTO usuarioCriado = usuarioService.criar(dto);
        return new ResponseEntity<>(usuarioCriado, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public UsuarioResponseDTO atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioRequestDTO dto) {
        return usuarioService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desativar(@PathVariable Long id) {
        usuarioService.desativar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/email/{email}")
    public UsuarioResponseDTO buscarPorEmail(@PathVariable String email) {
        return usuarioService.buscarPorEmail(email);
    }

    @GetMapping("/ativos/{ativo}")
    public List<UsuarioResponseDTO> buscarPorStatus(@PathVariable boolean ativo) {
        return usuarioService.buscarPorAtivo(ativo);
    }
}

