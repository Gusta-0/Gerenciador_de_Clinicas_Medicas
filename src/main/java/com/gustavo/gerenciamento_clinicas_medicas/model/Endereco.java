package com.gustavo.gerenciamento_clinicas_medicas.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Embeddable
@Data
@Builder
public class Endereco {
    @Schema(example = "Rua 15 de Maio", requiredMode = Schema.RequiredMode.REQUIRED, description = "Nome da rua")
    private String rua;
    @Schema(example = "123", requiredMode = Schema.RequiredMode.REQUIRED, description = "Número da residência")
    private String numero;
    @Schema(example = "Apto 101", requiredMode = Schema.RequiredMode.NOT_REQUIRED, description = "Complemento da residência")
    private String complemento;
    @Schema(example = "Centro", requiredMode = Schema.RequiredMode.NOT_REQUIRED, description = "Bairro da residência")
    private String bairro;
    @Schema(example = "São Paulo", requiredMode = Schema.RequiredMode.REQUIRED, description = "Cidade da residência")
    private String cidade;
    @Schema(example = "SP", requiredMode = Schema.RequiredMode.REQUIRED, description = "Estado da residência")
    private String estado;
    @Schema(example = "12345-678", requiredMode = Schema.RequiredMode.REQUIRED, description = "CEP da residência")
    private String cep;

    public Endereco() {

    }

    public Endereco(String rua, String numero, String complemento, String bairro, String cidade, String estado, String cep) {
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
}
