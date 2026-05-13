# 🛠️ SysManutenção API

API REST para gerenciamento de equipamentos e ordens de serviço, desenvolvida com **Java** e **Spring Boot**.

O projeto simula um sistema de manutenção onde é possível cadastrar equipamentos, ativar/inativar equipamentos, abrir ordens de serviço, listar registros, buscar por ID, alterar status de ordens e visualizar a documentação da API com Swagger/OpenAPI.

---

## 🎯 Objetivo do Projeto

O objetivo do **SysManutenção API** é aplicar conceitos de desenvolvimento backend com Java e Spring Boot em um cenário próximo de um sistema real de manutenção.

Este projeto é uma evolução da versão inicial em Java puro no terminal, agora utilizando uma arquitetura baseada em API REST, camadas bem definidas, DTOs, validações, persistência em banco H2 e documentação automática com Swagger.

---

## ⚙️ Funcionalidades

- ✅ Cadastro de equipamentos
- ✅ Listagem de equipamentos
- ✅ Busca de equipamento por ID
- ✅ Ativação de equipamento
- ✅ Inativação de equipamento
- ✅ Cadastro de ordens de serviço
- ✅ Listagem de ordens de serviço
- ✅ Busca de ordem de serviço por ID
- ✅ Alteração de status da ordem de serviço
- ✅ Relacionamento entre ordem de serviço e equipamento
- ✅ Validação de dados com Bean Validation
- ✅ Tratamento de erros personalizado
- ✅ Uso de DTOs para entrada e saída de dados
- ✅ Documentação da API com Swagger/OpenAPI
- ✅ Banco de dados em memória com H2

---

## 🧰 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- H2 Database
- Bean Validation
- Swagger/OpenAPI
- Maven
- Git e GitHub

---

## 📚 Conceitos Aplicados

Durante o desenvolvimento foram aplicados conceitos importantes de backend com Java, como:

- API REST
- Controllers
- Services
- Repositories
- Entities
- DTOs
- Validação de dados
- Tratamento global de exceções
- Relacionamento entre entidades
- Persistência com JPA/Hibernate
- Enums
- Injeção de dependência
- Organização em camadas
- Documentação com Swagger

---

## 📁 Estrutura do Projeto

```text
src/
└── main/
    ├── java/
    │   └── com/
    │       └── lucas/
    │           └── sysmanutencao/
    │               ├── SysmanutencaoApplication.java
    │               ├── config/
    │               │   └── OpenApiConfig.java
    │               ├── controller/
    │               │   ├── EquipamentoController.java
    │               │   └── OrdemServicoController.java
    │               ├── dto/
    │               │   ├── EquipamentoRequestDTO.java
    │               │   ├── EquipamentoResponseDTO.java
    │               │   ├── OrdemServicoRequestDTO.java
    │               │   ├── OrdemServicoResponseDTO.java
    │               │   ├── StatusOrdemRequestDTO.java
    │               │   └── ErrorResponseDTO.java
    │               ├── entity/
    │               │   ├── Equipamento.java
    │               │   └── OrdemServico.java
    │               ├── enums/
    │               │   ├── CategoriaEquipamentos.java
    │               │   ├── PrioridadeOrdem.java
    │               │   └── StatusOrdem.java
    │               ├── exception/
    │               │   ├── BusinessException.java
    │               │   ├── ResourceNotFoundException.java
    │               │   └── GlobalExceptionHandler.java
    │               ├── repository/
    │               │   ├── EquipamentoRepository.java
    │               │   └── OrdemServicoRepository.java
    │               └── service/
    │                   ├── EquipamentoService.java
    │                   └── OrdemServicoService.java
    └── resources/
        └── application.properties
```

---

## 🧱 Entidades

### 🔧 Equipamento

Representa um equipamento cadastrado no sistema.

Principais atributos:

```text
id
nomeEquipamento
categoriaEquipamento
dataCadastroEquipamento
statusEquipamento
```

---

### 📋 OrdemServico

Representa uma ordem de serviço vinculada a um equipamento.

Principais atributos:

```text
idOrdemServico
descricaoProblema
statusOrdemServico
prioridadeOrdemServico
dataAberturaOrdemServico
equipamento
```

---

## 🧩 Enums

O projeto utiliza `enum` para evitar valores inválidos e manter os dados padronizados.

### 🗂️ CategoriaEquipamentos

Exemplo:

```java
NOTEBOOK,
COMPUTADOR,
CELULAR,
IMPRESSORA,
MONITOR,
OUTRO
```

### 🚨 PrioridadeOrdem

Exemplo:

```java
BAIXA,
MEDIA,
ALTA
```

### 📌 StatusOrdem

Exemplo:

```java
ABERTA,
EM_ANDAMENTO,
CONCLUIDA,
CANCELADA
```

---

## 🌐 Endpoints da API

### 🔧 Equipamentos

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/equipamentos` | Cadastra um novo equipamento |
| GET | `/equipamentos` | Lista todos os equipamentos |
| GET | `/equipamentos/{id}` | Busca um equipamento por ID |
| PUT | `/equipamentos/{id}/inativar` | Inativa um equipamento |
| PUT | `/equipamentos/{id}/ativar` | Ativa um equipamento |

---

### 📋 Ordens de Serviço

| Método | Endpoint | Descrição |
|---|---|---|
| POST | `/ordens-servico` | Abre uma nova ordem de serviço |
| GET | `/ordens-servico` | Lista todas as ordens de serviço |
| GET | `/ordens-servico/{id}` | Busca uma ordem de serviço por ID |
| PUT | `/ordens-servico/{id}/status` | Altera o status de uma ordem de serviço |

---

## 🧪 Exemplos de Requisições

### Criar equipamento

```http
POST /equipamentos
```

```json
{
  "nomeEquipamento": "Notebook Dell",
  "categoriaEquipamento": "NOTEBOOK"
}
```

---

### Criar ordem de serviço

```http
POST /ordens-servico
```

```json
{
  "equipamentoId": 1,
  "descricaoProblema": "Tela não liga",
  "prioridadeOrdem": "ALTA"
}
```

---

### Alterar status da ordem

```http
PUT /ordens-servico/1/status
```

```json
{
  "statusOrdem": "EM_ANDAMENTO"
}
```

---

## 📖 Documentação Swagger

A API possui documentação automática com Swagger/OpenAPI.

Após iniciar a aplicação, acesse:

```text
http://localhost:8080/swagger-ui/index.html
```

No Swagger é possível visualizar e testar todos os endpoints da API.

---

## 🗄️ Banco de Dados H2

O projeto utiliza banco de dados H2 em memória para testes e desenvolvimento.

Após iniciar a aplicação, acesse:

```text
http://localhost:8080/h2-console
```

Configurações padrão:

```text
JDBC URL: jdbc:h2:mem:sysmanutencao
User Name: sa
Password:
```

---

## ▶️ Como Executar

### Pré-requisitos

É necessário ter instalado:

- Java 17+
- Maven

Verifique com:

```bash
java -version
```

```bash
mvn -version
```

---

### Clonar o repositório

```bash
git clone https://github.com/LucasSarnackiGuiraud/sysmanutencao-java-spring-api.git
```

---

### Entrar na pasta do projeto

```bash
cd sysmanutencao-java-spring-api
```

---

### Executar a aplicação

Com Maven:

```bash
mvn spring-boot:run
```

Ou pelo IntelliJ, execute a classe:

```text
SysmanutencaoApplication.java
```

---

## ✅ Tratamento de Erros

A API possui tratamento personalizado para erros como:

- Recurso não encontrado
- Regra de negócio inválida
- Erros de validação

Exemplo de resposta:

```json
{
  "status": 404,
  "erro": "Recurso não encontrado",
  "mensagem": "Equipamento não encontrado"
}
```

---

## 🚧 Próximas Melhorias

- Persistir dados em PostgreSQL
- Adicionar migrations com Flyway
- Criar autenticação com Spring Security e JWT
- Adicionar testes unitários
- Adicionar testes de integração
- Criar histórico de alterações da ordem de serviço
- Impedir inativação de equipamento com OS aberta ou em andamento
- Criar paginação e filtros
- Criar frontend com React
- Realizar deploy da API

---

## 📈 Evolução do Projeto

Este projeto está sendo desenvolvido em etapas:

```text
1. Java puro com terminal
2. Refatoração com orientação a objetos
3. Migração para Spring Boot
4. Criação de API REST
5. Integração com banco H2
6. DTOs de entrada e saída
7. Tratamento de erros
8. Documentação com Swagger
9. PostgreSQL
10. Segurança com JWT
11. Deploy
```

---

## 🧠 Aprendizados

Com este projeto, foram praticados conceitos fundamentais para desenvolvimento backend com Java e Spring Boot, principalmente:

- Criação de APIs REST
- Organização em camadas
- Separação entre Entity, DTO, Service, Repository e Controller
- Persistência de dados com JPA
- Relacionamento entre entidades
- Validação de dados
- Tratamento de exceções
- Documentação de API com Swagger

---

## 👨‍💻 Autor

Desenvolvido por **Lucas Guiraud**.

Projeto criado com foco em aprendizado e evolução na área de desenvolvimento backend com Java.
