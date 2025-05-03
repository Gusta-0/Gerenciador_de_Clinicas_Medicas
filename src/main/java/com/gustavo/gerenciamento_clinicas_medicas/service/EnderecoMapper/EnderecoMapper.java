package com.gustavo.gerenciamento_clinicas_medicas.service.EnderecoMapper;

import com.gustavo.gerenciamento_clinicas_medicas.dto.request.EnderecoRequestDTO;
import com.gustavo.gerenciamento_clinicas_medicas.dto.response.EnderecoResponseDTO;
import com.gustavo.gerenciamento_clinicas_medicas.model.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {

    public Endereco toEntity(EnderecoRequestDTO request) {
        return Endereco.builder()
                .rua(request.Rua().trim())
                .numero(request.numero())
                .complemento(request.complemento() != null ? request.complemento().trim() : null)
                .bairro(request.bairro().trim())
                .cidade(request.cidade().trim())
                .estado(request.estado().toUpperCase().trim())
                .cep(request.cep().replace("-", "")) // Remove hífen do CEP
                .build();
    }

    public EnderecoResponseDTO toResponse(Endereco entity) {
        return new EnderecoResponseDTO(
                entity.getRua(),
                entity.getNumero(),
                entity.getComplemento(),
                entity.getBairro(),
                entity.getCidade(),
                entity.getEstado(),
                formatarCep(entity.getCep()),
                gerarEnderecoCompleto(entity)
        );
    }

    private String formatarCep(String cep) {
        return cep.replaceAll("(\\d{5})(\\d{3})", "$1-$2");
    }

    private String gerarEnderecoCompleto(Endereco endereco) {
        return String.format("%s, %s%s - %s, %s/%s - CEP: %s",
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getComplemento() != null ? " (" + endereco.getComplemento() + ")" : "",
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getEstado(),
                formatarCep(endereco.getCep())
        );
    }
}
