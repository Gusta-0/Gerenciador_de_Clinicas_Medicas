# Sistema de Gerenciamento de Clínica Médica 🏥

## Visão Geral
API RESTful para gestão de clínicas médicas, incluindo:
- 👨‍⚕️ Cadastro de médicos e pacientes  
- 📅 Agendamento de consultas  
- 🔐 Autenticação segura com JWT  
- 📊 Relatórios de disponibilidade  
- 📚 Documentação Swagger integrada



🛠️ Como Executar
Pré-requisitos:

bash
Copy
Java 17+, Maven 3.9+, PostgreSQL 14+
Configuração:

bash
Copy
git clone https://github.com/seu-usuario/clinica-api.git
cd clinica-api
Banco de Dados:

bash
Copy
docker run --name clinica-db -e POSTGRES_PASSWORD=senha -p 5432:5432 -d postgres:14
Aplicação:

bash
Copy
./mvnw spring-boot:run
Acesse: http://localhost:8080/swagger-ui.html

📌 Regras de Negócio
Consultas:

Não podem ser agendadas no passado

Médico não pode ter 2 consultas no mesmo horário

Cancelamento até 24h antes

Disponibilidade:

Médicos definem horários de trabalho

Bloqueios automáticos em feriados

📚 Documentação
Ferramenta	URL
Swagger UI	http://localhost:8080/swagger-ui
Actuator	http://localhost:8080/actuator

📅 Roadmap
Integração com WhatsApp API

Prontuário eletrônico

Dashboard de métricas

📜 Licença
MIT License © 2023 - [Seu Nome]

Copy

### Recursos Incluídos:
1. **Diagrama Mermaid** completo
2. **Tabelas organizadas** por tecnologias
3. **Exemplos de endpoints** com sintaxe HTTP
4. **Guia de execução** com comandos reais
5. **Destaques visuais** com emojis
6. **Seção de regras** de negócio importantes

Para usar:
1. Copie todo o conteúdo
2. Cole em um arquivo `README.md` no raiz do projeto
3. Personalize com seus dados reais (links, nomes, etc.)


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
