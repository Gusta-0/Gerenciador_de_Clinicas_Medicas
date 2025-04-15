# Sistema de Gerenciamento de Clínica Médica 🏥

## Visão Geral
API RESTful para gestão de clínicas médicas, incluindo:
- 👨‍⚕️ Cadastro de médicos e pacientes  
- 📅 Agendamento de consultas  
- 🔐 Autenticação segura com JWT  
- 📊 Relatórios de disponibilidade  
- 📚 Documentação Swagger integrada

## Tecnologias
| Área           | Tecnologias                          |
|----------------|--------------------------------------|
| Backend        | Spring Boot 3, Java 17               |
| Persistência   | Spring Data JPA, Hibernate, PostgreSQL |
| Segurança      | Spring Security, JWT                 |
| Documentação   | Swagger (OpenAPI 3.0)                |
| Testes         | JUnit 5, Mockito                     |

```mermaid
classDiagram
    direction TB

    class Usuario {
        <<abstract>>
        +Long id
        +String nome
        +String email
        +String senha
        +TipoUsuario role
        +Boolean ativo
    }

    class Medico {
        +String crm
        +String especialidade
        +adicionarDisponibilidade()
        +removerDisponibilidade()
    }

    class Paciente {
        +String cpf
        +LocalDate dataNascimento
        +String telefone
    }

    class Endereco {
        <<embeddable>>
        +String logradouro
        +String numero
        +String complemento
        +String cidade
        +String estado
        +String cep
    }

    class Consulta {
        +LocalDateTime dataHora
        +StatusConsulta status
        +String observacoes
    }

    class Disponibilidade {
        +DayOfWeek diaSemana
        +LocalTime horaInicio
        +LocalTime horaFim
        +Boolean disponivel
    }

    class TipoUsuario {
        <<enum>>
        ADMIN
        MEDICO
        PACIENTE
    }

    class StatusConsulta {
        <<enum>>
        AGENDADA
        CONFIRMADA
        CANCELADA
        REALIZADA
    }

    Usuario <|-- Medico
    Usuario <|-- Paciente
    Paciente "1" *-- "1" Endereco
    Medico "1" *-- "*" Disponibilidade : possui
    Medico "1" -- "*" Consulta : atende
    Paciente "1" -- "*" Consulta : agenda
    Consulta --> StatusConsulta
    Usuario --> TipoUsuario
