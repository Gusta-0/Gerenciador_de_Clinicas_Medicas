package com.gustavo.gerenciamento_clinicas_medicas.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Embeddable
@Data
@Table(name = "Endereco")
@Builder
public class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco() {

    }
}
