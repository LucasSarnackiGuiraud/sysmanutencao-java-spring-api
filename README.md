# 🛠️ SysManutenção

Sistema de gerenciamento de manutenção desenvolvido em **Java**, com foco em praticar **Programação Orientada a Objetos**, organização de projeto, uso de `enum`, `services`, validações e relacionamento entre classes.

O projeto simula um sistema interno para cadastro de equipamentos e abertura de ordens de serviço, permitindo controlar equipamentos cadastrados, categorias, status, prioridade e operações básicas diretamente pelo terminal.

---

## 🎯 Objetivo do Projeto

O objetivo do **SysManutenção** é aplicar conceitos fundamentais de Java em um problema próximo de um cenário real: o controle de manutenção de equipamentos.

Este projeto foi criado como parte do meu processo de aprendizado em Java, servindo como base para uma futura evolução para uma **API REST com Spring Boot**, banco de dados e frontend.

---

## ⚙️ Funcionalidades

- ✅ Cadastro de equipamentos
- ✅ Listagem de equipamentos
- ✅ Inativação e reativação de equipamentos
- ✅ Cadastro de ordens de serviço
- ✅ Listagem de ordens de serviço
- ✅ Alteração de status da ordem de serviço
- ✅ Uso de categorias para equipamentos
- ✅ Uso de prioridades para ordens de serviço
- ✅ Uso de status para controle das ordens
- ✅ Geração automática de ID
- ✅ Registro de data de cadastro e abertura
- ✅ Validações básicas de entrada
- ✅ Organização do projeto em camadas

---

## 🧰 Tecnologias Utilizadas

- Java
- Programação Orientada a Objetos
- ArrayList
- Enum
- LocalDate
- Scanner
- Git e GitHub

---

## 📚 Conceitos Aplicados

Durante o desenvolvimento foram aplicados conceitos importantes de Java, como:

- Classes e objetos
- Encapsulamento
- Construtores
- Getters e setters
- Métodos estáticos
- Enum
- Tratamento de exceções
- Listas com ArrayList
- Separação de responsabilidades
- Organização por pacotes
- Relacionamento entre objetos
- Sobrescrita do método `toString()`

---

## 📁 Estrutura do Projeto

```text
src/
└── com/
    └── lucas/
        └── sysmanutencao/
            ├── Main.java
            ├── model/
            │   ├── Equipamento.java
            │   ├── OrdemServico.java
            │   ├── CategoriaEquipamento.java
            │   ├── PrioridadeOrdem.java
            │   └── StatusOrdem.java
            ├── service/
            │   ├── EquipamentoService.java
            │   └── OrdemServicoService.java
            └── util/
                └── InputUtil.java
```

---

## 🧱 Models

### 🔧 Equipamento

Representa um equipamento cadastrado no sistema.

Principais atributos:

```text
idEquipamento
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
equipamentoOrdem
descricaoProblema
statusOrdemServico
prioridadeOrdemServico
dataAberturaOrdemServico
```

---

## 🧩 Enums

O projeto utiliza `enum` para evitar o uso de textos soltos no sistema e reduzir erros de digitação.

### 🗂️ CategoriaEquipamento

Exemplo:

```java
NOTEBOOK,
COMPUTADOR,
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

## ▶️ Como Executar

### ✅ Pré-requisitos

É necessário ter o Java instalado na máquina.

Verifique com:

```bash
java -version
```

E também:

```bash
javac -version
```

---

### 🏗️ Compilar o projeto

Na raiz do projeto, execute:

```bash
javac -d out src/com/lucas/sysmanutencao/**/*.java src/com/lucas/sysmanutencao/Main.java
```

---

### 🚀 Executar o projeto

```bash
java -cp out com.lucas.sysmanutencao.Main
```

---

## 🖥️ Menu do Sistema

Ao executar o sistema, será exibido um menu no terminal:

```text
=== Escolha uma opção ===
1 - Criar Equipamento
2 - Listar Equipamentos
3 - Inativar ou Ativar Equipamento
4 - Abrir Ordem de Serviço
5 - Listar Ordens de Serviço
6 - Trocar o status da Ordem
0 - Fechar Menu
```

---

## 🧪 Exemplo de Uso

### Cadastro de equipamento

```text
Nome do Equipamento: Notebook Dell
Categoria do Equipamento: NOTEBOOK
Equipamento cadastrado com sucesso!
```

### Abertura de ordem de serviço

```text
Aparelho danificado: Notebook Dell
Problema danificado: Tela não liga
Prioridade da ordem: ALTA
Ordem aberta com sucesso!
```

---

## 🚧 Próximas Melhorias

- Criar histórico de alterações da ordem de serviço
- Impedir abertura de OS para equipamento inativo
- Impedir inativação de equipamento com OS aberta ou em andamento
- Melhorar validação de entradas do usuário
- Criar busca por ID
- Separar melhor responsabilidades entre `Main` e `Service`
- Persistir dados em arquivo
- Migrar para Spring Boot
- Criar API REST
- Integrar com banco de dados PostgreSQL
- Criar frontend com React
- Adicionar autenticação de usuários
- Criar documentação com Swagger
- Adicionar testes unitários

---

## 📈 Evolução Planejada

Este projeto será evoluído em etapas:

```text
1. Java puro com terminal
2. Refatoração com orientação a objetos
3. Persistência simples
4. API REST com Spring Boot
5. Banco de dados PostgreSQL
6. Frontend com React
7. Autenticação com JWT
8. Deploy
```

---

## 🧠 Aprendizados

Com este projeto, foram praticados conceitos fundamentais para o desenvolvimento backend com Java, principalmente a criação de sistemas orientados a objetos e a organização do código em camadas.

O projeto também servirá como base para aprender Spring Boot, já que sua estrutura atual já possui separação entre `models`, `services` e utilitários.

---

## 👨‍💻 Autor

Desenvolvido por **Lucas Guiraud**.

Projeto criado com foco em aprendizado e evolução para backend Java.
