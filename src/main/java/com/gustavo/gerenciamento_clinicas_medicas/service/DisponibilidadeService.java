package com.gustavo.gerenciamento_clinicas_medicas.service;

import com.gustavo.gerenciamento_clinicas_medicas.dto.request.DisponibilidadeRequest;
import com.gustavo.gerenciamento_clinicas_medicas.model.Disponibilidade;
import com.gustavo.gerenciamento_clinicas_medicas.model.Medico;
import com.gustavo.gerenciamento_clinicas_medicas.repository.DisponibilidadeRepository;
import com.gustavo.gerenciamento_clinicas_medicas.repository.MedicoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DisponibilidadeService {

    private final DisponibilidadeRepository repository;
    private final MedicoRepository medicoRepository;

    public Disponibilidade criar(DisponibilidadeRequest request) {
        // Verifica se médico existe
        Medico medico = medicoRepository.findById(request.medicoId())
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));

        // Valida conflito de horário
//        if (repository.existsByMedicoAndDiaSemanaAndHoraInicioLessThanAndHoraFimGreaterThan(
//                medico,
//                request.diaSemana(),
//                request.horaInicio(),
//                request.horaFim())) {
//            throw new BusinessException("Já existe disponibilidade neste horário");
//        }

        Disponibilidade disponibilidade = new Disponibilidade();
        disponibilidade.setMedico(medico);
        disponibilidade.setDiaSemana(request.diaSemana());
        disponibilidade.setHoraInicio(request.horaInicio());
        disponibilidade.setHoraFim(request.horaFim());
        disponibilidade.setDisponivel(request.disponivel());

        return repository.save(disponibilidade);
    }
}
