package com.gustavo.gerenciamento_clinicas_medicas.dto.response;
import com.gustavo.gerenciamento_clinicas_medicas.model.Paciente;
import java.time.LocalDate;

public record PacienteResponseDTO(
    Long id,
    String nome,
    String email,
    String cpf,
    LocalDate dataNascimento,
    String telefone,
    EnderecoResponseDTO endereco
) {
    public static PacienteResponseDTO fromEntity(Paciente paciente) {
        return new PacienteResponseDTO(
            paciente.getId(),
            paciente.getNome(),
            paciente.getEmail(),
            paciente.getCpf(),
            paciente.getDataNascimento(),
            paciente.getTelefone(),
            EnderecoResponseDTO.fromEntity(paciente.getEndereco())
        );
    }
}