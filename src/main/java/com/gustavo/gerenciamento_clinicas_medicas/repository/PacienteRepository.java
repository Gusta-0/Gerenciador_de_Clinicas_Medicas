package com.gustavo.gerenciamento_clinicas_medicas.repository;

import com.gustavo.gerenciamento_clinicas_medicas.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Optional<Paciente> findByCpf(String cpf);

    @Query("SELECT p FROM Paciente p WHERE p.dataNascimento BETWEEN :start AND :end")
    List<Paciente> findByFaixaEtaria(
            @Param("start") LocalDate start,
            @Param("end") LocalDate end);

    @Query("SELECT p FROM Paciente p WHERE p.endereco.cidade = :cidade")
    List<Paciente> findByCidade(@Param("cidade") String cidade);

    @Query("SELECT DISTINCT p FROM Paciente p JOIN p.consultas c WHERE c.status = 'AGENDADA'")
    List<Paciente> findComConsultasAgendadas();
}
