package com.gustavo.gerenciamento_clinicas_medicas.service;

import com.gustavo.gerenciamento_clinicas_medicas.dto.request.MedicoRequestDTO;
import com.gustavo.gerenciamento_clinicas_medicas.dto.response.MedicoResponseDTO;
import com.gustavo.gerenciamento_clinicas_medicas.model.Medico;
import com.gustavo.gerenciamento_clinicas_medicas.repository.MedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository medicoRepository;

    public MedicoService(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    public List<MedicoResponseDTO> listarTodos() {
        return medicoRepository.findAll().stream()
                .map(MedicoResponseDTO::fromEntity)
                .toList();
    }

    public MedicoResponseDTO buscarPorId(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado com ID: " + id));
        return MedicoResponseDTO.fromEntity(medico);
    }

    public MedicoResponseDTO criar(MedicoRequestDTO dto) {
        if (medicoRepository.existsByCrm(dto.crm())) {
            throw new IllegalArgumentException("Já existe um médico com esse CRM.");
        }

        Medico medico = new Medico();
        medico.setNome(dto.nome());
        medico.setCrm(dto.crm());
        medico.setEspecialidade(dto.especialidade());
        medico.setAtivo(true);

        Medico salvo = medicoRepository.save(medico);
        return MedicoResponseDTO.fromEntity(salvo);
    }


    public MedicoResponseDTO atualizar(Long id, Medico medico) {
        Medico medicoExistente = medicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado com ID: " + id));

        medicoExistente.setNome(medico.getNome());
        medicoExistente.setCrm(medico.getCrm());
        medicoExistente.setEspecialidade(medico.getEspecialidade());

        Medico salvo = medicoRepository.save(medicoExistente);
        return MedicoResponseDTO.fromEntity(salvo);
    }

    public void deletar(Long id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado com ID: " + id));
        medicoRepository.delete(medico);
    }

    public List<MedicoResponseDTO> buscarPorEspecialidade(String especialidade) {
        return medicoRepository.findByEspecialidade(especialidade).stream()
                .map(MedicoResponseDTO::fromEntity)
                .toList();
    }

}
