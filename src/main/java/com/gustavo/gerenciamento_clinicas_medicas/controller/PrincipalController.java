package com.gustavo.gerenciamento_clinicas_medicas.controller;

import com.gustavo.gerenciamento_clinicas_medicas.dto.request.ConsultaRequest;
import com.gustavo.gerenciamento_clinicas_medicas.dto.response.ConsultaResponse;
import com.gustavo.gerenciamento_clinicas_medicas.model.Consulta;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class PrincipalController {

//    @PostMapping
//    public ResponseEntity<ConsultaResponse> agendarConsulta(
//            @RequestBody @Valid ConsultaRequest request) {
//
//        Consulta consulta = consultaService.agendar(request);
//        return ResponseEntity.created(URI.create("/consultas/" + consulta.getId()))
//                .body(ConsultaResponse.fromEntity(consulta));
//    }

//    @PostMapping
//    public ResponseEntity<EnderecoResponse> criar(
//            @RequestBody @Valid EnderecoRequest request) {
//        Endereco endereco = enderecoService.criar(request);
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(EnderecoResponse.fromEntity(endereco));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<EnderecoResponse> buscarPorId(@PathVariable Long id) {
//        return ResponseEntity.ok(
//                EnderecoResponse.fromEntity(enderecoService.buscarPorId(id))
//        );
//    }
}
