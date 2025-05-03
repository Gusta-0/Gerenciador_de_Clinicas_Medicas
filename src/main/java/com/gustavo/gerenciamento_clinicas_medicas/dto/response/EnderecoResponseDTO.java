package com.gustavo.gerenciamento_clinicas_medicas.dto.response;

import com.gustavo.gerenciamento_clinicas_medicas.model.Endereco;

public record EnderecoResponseDTO(
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep,
        String enderecoCompleto
) {
    public static EnderecoResponseDTO fromEntity(Endereco endereco) {
        return new EnderecoResponseDTO(
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                formatarCep(endereco.getCep()),
                gerarEnderecoCompleto(endereco)
        );
    }

    private static String formatarCep(String cep) {
        return cep.replaceAll("(\\d{5})(\\d{3})", "$1-$2");
    }

    private static String gerarEnderecoCompleto(Endereco endereco) {
        String complemento = endereco.getComplemento();
        String complementoFormatado = (complemento != null && !complemento.isBlank()) ? " (" + complemento + ")" : "";

        return String.format("%s, %s%s - %s, %s/%s - CEP: %s",
                endereco.getRua(),
                endereco.getNumero(),
                complementoFormatado,
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                formatarCep(endereco.getCep()));
    }

}
