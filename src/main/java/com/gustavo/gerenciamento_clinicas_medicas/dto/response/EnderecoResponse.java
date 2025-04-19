package com.gustavo.gerenciamento_clinicas_medicas.dto.response;

import com.gustavo.gerenciamento_clinicas_medicas.model.Endereco;

public record EnderecoResponse(
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String cep,
        String enderecoCompleto
) {
    public static EnderecoResponse fromEntity(Endereco endereco) {
        return new EnderecoResponse(
                endereco.getLogradouro(),
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
        return String.format("%s, %s %s - %s, %s/%s - CEP: %s",
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento() != null ? "(" + endereco.getComplemento() + ")" : "",
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                formatarCep(endereco.getCep())
        );
    }
}
