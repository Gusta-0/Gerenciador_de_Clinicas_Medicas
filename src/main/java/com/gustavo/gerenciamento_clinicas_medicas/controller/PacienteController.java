package com.gustavo.gerenciamento_clinicas_medicas.controller;

import com.gustavo.gerenciamento_clinicas_medicas.dto.request.PacienteRequestDTO;
import com.gustavo.gerenciamento_clinicas_medicas.dto.response.PacienteResponseDTO;
import com.gustavo.gerenciamento_clinicas_medicas.service.PacienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
@Tag(name = "Paciente", description = "Gerenciamento de pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<PacienteResponseDTO> criar(@Valid @RequestBody PacienteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<PacienteResponseDTO>> listarTodos() {
        return ResponseEntity.ok(pacienteService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pacienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/faixa-etaria")
    public ResponseEntity<List<PacienteResponseDTO>> buscarPorFaixaEtaria(
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam("fim") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim) {
        return ResponseEntity.ok(pacienteService.buscarPorFaixaEtaria(inicio, fim));
    }

    @GetMapping("/cidade")
    public ResponseEntity<List<PacienteResponseDTO>> buscarPorCidade(@RequestParam("nome") String cidade) {
        return ResponseEntity.ok(pacienteService.buscarPorCidade(cidade));
    }

    @GetMapping("/consultas-agendadas")
    public ResponseEntity<List<PacienteResponseDTO>> buscarComConsultasAgendadas() {
        return ResponseEntity.ok(pacienteService.buscarComConsultasAgendadas());
    }
}

