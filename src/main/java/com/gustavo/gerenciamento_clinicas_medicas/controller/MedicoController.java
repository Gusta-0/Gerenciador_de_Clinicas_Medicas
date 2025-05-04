package com.gustavo.gerenciamento_clinicas_medicas.controller;

import com.gustavo.gerenciamento_clinicas_medicas.dto.request.MedicoRequestDTO;
import com.gustavo.gerenciamento_clinicas_medicas.dto.response.MedicoResponseDTO;
import com.gustavo.gerenciamento_clinicas_medicas.model.Medico;
import com.gustavo.gerenciamento_clinicas_medicas.service.MedicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
@Tag(name = "Medico" , description = "Gerenciamento de Médicos")
public class MedicoController {
    
    private final MedicoService medicoService;
    
    public MedicoController(MedicoService medicoService) {
        this.medicoService = medicoService;
    }
    
    @PostMapping
    @Operation(summary = "Cadastro de médicos", description = "Essa função é responsável por cadastrar um médico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Medico.class))
            }),
            @ApiResponse(responseCode = "400", description = "Médico já cadastrado")
    })
    public ResponseEntity<MedicoResponseDTO> criar(@RequestBody @Valid MedicoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.criar(dto));
    }

    @GetMapping
    @Operation(summary = "Listar médicos", description = "Essa função é responsável por listar todos os médicos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Medico.class))
            }),
            @ApiResponse(responseCode = "404", description = "Nenhum médico encontrado")
    })
    public ResponseEntity<List<MedicoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(medicoService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar médico por ID", description = "Essa função é responsável por buscar um médico pelo ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Medico.class))
            }),
            @ApiResponse(responseCode = "404", description = "Médico não encontrado")
    })
    public ResponseEntity<MedicoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(medicoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar médico", description = "Essa função é responsável por atualizar um médico")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Medico.class))
            }),
            @ApiResponse(responseCode = "404", description = "Médico não encontrado")
    })
    public ResponseEntity<MedicoResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid Medico medico) {
        return ResponseEntity.ok(medicoService.atualizar(id, medico));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar médico", description = "Essa função é responsável por deletar um médico")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Médico deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Médico não encontrado")
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        medicoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/especialidade")
    @Operation(summary = "Buscar médicos por especialidade", description = "Essa função é responsável por buscar médicos por especialidade")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Medico.class))
            }),
            @ApiResponse(responseCode = "404", description = "Nenhum médico encontrado")
    })
    public ResponseEntity<List<MedicoResponseDTO>> buscarPorEspecialidade(@RequestParam String especialidade) {
        return ResponseEntity.ok(medicoService.buscarPorEspecialidade(especialidade));
    }

}
