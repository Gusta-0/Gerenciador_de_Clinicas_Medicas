package com.gustavo.gerenciamento_clinicas_medicas.repository;

import com.gustavo.gerenciamento_clinicas_medicas.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    @Query("SELECT c FROM Consulta c WHERE c.medico.id = :medicoId AND c.dataHora BETWEEN :start AND :end")
    List<Consulta> findByMedicoAndPeriodo(
            @Param("medicoId") Long medicoId,
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end);

    @Query("SELECT c FROM Consulta c WHERE c.paciente.id = :pacienteId ORDER BY c.dataHora DESC")
    List<Consulta> findHistoricoPorPaciente(@Param("pacienteId") Long pacienteId);

    @Query("SELECT COUNT(c) FROM Consulta c WHERE c.medico.id = :medicoId AND c.status = 'REALIZADA'")
    long countConsultasRealizadasPorMedico(@Param("medicoId") Long medicoId);

    @Query("SELECT c FROM Consulta c WHERE c.status = :status AND c.dataHora < :now")
    List<Consulta> findConsultasPassadasPorStatus(
            @Param("status") Consulta.StatusConsulta status,
            @Param("now") LocalDateTime now);
}
