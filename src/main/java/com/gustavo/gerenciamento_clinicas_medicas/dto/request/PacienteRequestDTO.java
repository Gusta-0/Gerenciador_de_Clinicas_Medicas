package com.gustavo.gerenciamento_clinicas_medicas.dto.request;

import com.gustavo.gerenciamento_clinicas_medicas.model.Endereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record PacienteRequestDTO (
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "Email é obrigatório")
        String email,

        @NotBlank(message = "CPF é obrigatório")
        String cpf,

        @Past(message = "A data de nascimento deve estar no passado")
        @NotNull(message = "Data de nascimento é obrigatória")
        LocalDate dataNascimento,

        String telefone,

        @NotNull(message = "Endereço é obrigatório")
        EnderecoRequestDTO endereco
){
        public static Endereco toEntity(EnderecoRequestDTO dto) {
                Endereco endereco = new Endereco();
                endereco.setCep(dto.cep());
                endereco.setRua(dto.Rua());
                endereco.setNumero(dto.numero());
                endereco.setComplemento(dto.complemento());
                endereco.setBairro(dto.bairro());
                endereco.setCidade(dto.cidade());
                endereco.setEstado(dto.estado());
                return endereco;
        }
}
