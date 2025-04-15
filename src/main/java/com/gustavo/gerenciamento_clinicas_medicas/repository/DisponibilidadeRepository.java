package com.gustavo.gerenciamento_clinicas_medicas.repository;

import com.gustavo.gerenciamento_clinicas_medicas.model.Disponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.DayOfWeek;
import java.util.List;

public interface DisponibilidadeRepository extends JpaRepository<Disponibilidade, Long> {
    @Query("SELECT d FROM Disponibilidade d WHERE d.medico.id = :medicoId AND d.diaSemana = :dia")
    List<Disponibilidade> findByMedicoAndDia(
            @Param("medicoId") Long medicoId,
            @Param("dia") DayOfWeek dia);

    @Query("SELECT d FROM Disponibilidade d WHERE d.medico.id = :medicoId AND d.disponivel = true")
    List<Disponibilidade> findDisponiveisPorMedico(@Param("medicoId") Long medicoId);

    @Query("SELECT d FROM Disponibilidade d WHERE d.medico.especialidade = :especialidade AND d.diaSemana = :dia AND d.disponivel = true")
    List<Disponibilidade> findDisponiveisPorEspecialidadeEDia(
            @Param("especialidade") String especialidade,
            @Param("dia") DayOfWeek dia);
}
