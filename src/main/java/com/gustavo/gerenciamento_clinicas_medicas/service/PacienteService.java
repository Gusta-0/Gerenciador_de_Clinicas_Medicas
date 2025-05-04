package com.gustavo.gerenciamento_clinicas_medicas.service;

import com.gustavo.gerenciamento_clinicas_medicas.dto.request.EnderecoRequestDTO;
import com.gustavo.gerenciamento_clinicas_medicas.dto.request.PacienteRequestDTO;
import com.gustavo.gerenciamento_clinicas_medicas.dto.response.PacienteResponseDTO;
import com.gustavo.gerenciamento_clinicas_medicas.model.Paciente;
import com.gustavo.gerenciamento_clinicas_medicas.repository.PacienteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public PacienteResponseDTO criar(PacienteRequestDTO dto) {
        if (dto.endereco() == null) {
            throw new IllegalArgumentException("Endereço não pode ser nulo");
        }
        
        Paciente paciente1 = new Paciente();
        paciente1.setNome(dto.nome());
        paciente1.setEmail(dto.email());
        paciente1.setCpf(dto.cpf());
        paciente1.setDataNascimento(dto.dataNascimento());
        paciente1.setTelefone(dto.telefone());

        Paciente paciente = pacienteRepository.save(paciente1);
        return PacienteResponseDTO.fromEntity(pacienteRepository.save(paciente));
    }

    public List<PacienteResponseDTO> listarTodos() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteResponseDTO::fromEntity)
                .toList();
    }

    public PacienteResponseDTO buscarPorId(Long id) {
        return pacienteRepository.findById(id)
                .map(PacienteResponseDTO::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
    }

    public void deletar(Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new EntityNotFoundException("Paciente não encontrado");
        }
        pacienteRepository.deleteById(id);
    }

    public List<PacienteResponseDTO> buscarPorFaixaEtaria(LocalDate inicio, LocalDate fim) {
        return pacienteRepository.findByFaixaEtaria(inicio, fim)
                .stream()
                .map(PacienteResponseDTO::fromEntity)
                .toList();
    }

    public List<PacienteResponseDTO> buscarPorCidade(String cidade) {
        return pacienteRepository.findByCidade(cidade)
                .stream()
                .map(PacienteResponseDTO::fromEntity)
                .toList();
    }

    public List<PacienteResponseDTO> buscarComConsultasAgendadas() {
        return pacienteRepository.findComConsultasAgendadas()
                .stream()
                .map(PacienteResponseDTO::fromEntity)
                .toList();
    }
}