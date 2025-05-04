package com.gustavo.gerenciamento_clinicas_medicas.repository;

import com.gustavo.gerenciamento_clinicas_medicas.model.Medico;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Optional<Medico> findByCrm(String crm);

    @Query("SELECT m FROM Medico m WHERE m.especialidade = :especialidade")
    List<Medico> findByEspecialidade(@Param("especialidade") String especialidade);

    @Query("SELECT m FROM Medico m JOIN m.disponibilidades d WHERE d.diaSemana = :dia AND d.disponivel = true")
    List<Medico> findDisponiveisPorDia(@Param("dia") DayOfWeek dia);

    @Query("SELECT m FROM Medico m WHERE SIZE(m.consultas) > :minConsultas")
    List<Medico> findMaisAtivos(@Param("minConsultas") int minConsultas);

    boolean existsByCrm(@NotBlank String crm);
}
