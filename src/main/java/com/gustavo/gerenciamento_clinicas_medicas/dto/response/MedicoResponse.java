package com.gustavo.gerenciamento_clinicas_medicas.dto.response;

import com.gustavo.gerenciamento_clinicas_medicas.model.Consulta;
import com.gustavo.gerenciamento_clinicas_medicas.model.Disponibilidade;
import com.gustavo.gerenciamento_clinicas_medicas.model.Medico;

import java.util.List;

public class MedicoResponse {
    Long id;
    String crm;
    String especialidade;
    String nome;
    String email;

    // Relacionamentos (opcional incluir apenas IDs ou objetos reduzidos)
//    List<DisponibilidadeResumidaResponse> disponibilidades;
//    List<ConsultaResumidaResponse> consultas;

    // Estatísticas calculadas (opcional)
    Long totalConsultas;
    String statusAtividade;


    {
//        // Método de conversão da entidade para DTO
//        public static MedicoResponse fromEntity(Medico medico) {
//            return new MedicoResponse(
//                    medico.getId(),
//                    medico.getCrm(),
//                    medico.getEspecialidade(),
//                    medico.getNome(),
//                    medico.getEmail(),
//                    medico.getDisponibilidades().stream()
//                            .map(DisponibilidadeResumidaResponse::fromEntity)
//                            .toList(),
//                    medico.getConsultas().stream()
//                            .map(ConsultaResumidaResponse::fromEntity)
//                            .toList(),
//                    (long) medico.getConsultas().size(),
//                    medico.getDisponibilidades().isEmpty() ? "INATIVO" : "ATIVO"
//            );
//        }
//    }

        // Records auxiliares para relacionamentos
        record DisponibilidadeResumidaResponse(
                Long id,
                String diaSemana,
                String horario
        ) {
            public static DisponibilidadeResumidaResponse fromEntity(Disponibilidade disponibilidade) {
                return new DisponibilidadeResumidaResponse(
                        disponibilidade.getId(),
                        disponibilidade.getDiaSemana().name(),
                        disponibilidade.getHoraInicio() + " às " + disponibilidade.getHoraFim()
                );
            }
        }

        record ConsultaResumidaResponse(
                Long id,
                String dataHora,
                String status
        ) {
            public static ConsultaResumidaResponse fromEntity(Consulta consulta) {
                return new ConsultaResumidaResponse(
                        consulta.getId(),
                        consulta.getDataHora().toString(),
                        consulta.getStatus().name()
                );
            }
        }
    }
}