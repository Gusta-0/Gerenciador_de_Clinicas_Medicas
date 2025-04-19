package com.gustavo.gerenciamento_clinicas_medicas.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EnderecoRequest(
        @NotBlank(message = "Logradouro é obrigatório")
        @Size(max = 100, message = "Logradouro deve ter no máximo 100 caracteres")
        String logradouro,

        @NotBlank(message = "Número é obrigatório")
        @Size(max = 10, message = "Número deve ter no máximo 10 caracteres")
        String numero,

        @Size(max = 50, message = "Complemento deve ter no máximo 50 caracteres")
        String complemento,

        @NotBlank(message = "Bairro é obrigatório")
        @Size(max = 50, message = "Bairro deve ter no máximo 50 caracteres")
        String bairro,

        @NotBlank(message = "Cidade é obrigatória")
        @Size(max = 50, message = "Cidade deve ter no máximo 50 caracteres")
        String cidade,

        @NotBlank(message = "Estado é obrigatório")
        @Size(min = 2, max = 2, message = "Estado deve ter 2 caracteres (UF)")
        String estado,

        @NotBlank(message = "CEP é obrigatório")
        @Pattern(regexp = "\\d{5}-?\\d{3}", message = "CEP deve seguir o padrão 00000-000 ou 00000000")
        String cep
) {
}

/* request {
  "logradouro": "Rua das Flores",
  "numero": "123",
  "complemento": "Apto 101",
  "bairro": "Centro",
  "cidade": "São Paulo",
  "estado": "SP",
  "cep": "01001000"
} */


