# Escola

Este projeto tem como objetivo criar um ambiente simples para gerenciamento de uma escola, servindo como base para estudos de desenvolvimento web com Java e Spring Boot.

> **Atenção:** Este é um projeto para fins de teste e aprendizado.

## Descrição

O sistema simula operações básicas comuns em um ambiente escolar, como cadastro e consulta de alunos, professores, turmas e disciplinas. O foco está em oferecer uma estrutura inicial para quem deseja aprender sobre aplicações web, APIs RESTful e integração com banco de dados utilizando o ecossistema Spring.

## Funcionalidades Principais

- Cadastro de alunos, professores e turmas
- Consulta de informações cadastradas
- API RESTful para operações de CRUD (Create, Read, Update, Delete)
- Estrutura modular para fácil expansão

## Tecnologias Utilizadas

- **Java 11+**
- **Spring Boot**
- **Maven**
- **MongoDB
- **Spring Data JPA**

## Como Rodar o Projeto

### Pré-requisitos

- Java 17 ou superior instalado
- Git instalado

### Passos para executar

1. Clone o repositório:
    ```bash
    git clone https://github.com/johnsm1/escola.git
    ```
2. Acesse a pasta do projeto:
    ```bash
    cd escola
    ```
3. Execute o projeto:
    - No Linux/Mac:
        ```bash
        ./mvnw spring-boot:run
        ```
    - No Windows:
        ```bash
        mvnw spring-boot:run
        ```

O projeto será iniciado em `http://localhost:8080`.

## Endpoints Principais

- `GET /alunos` : Lista todos os alunos
- `POST /alunos` : Cadastra um novo aluno
- `GET /professores` : Lista todos os professores
- `POST /turmas` : Cadastra uma nova turma

## Estrutura do Projeto

```
escola/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── ... (código fonte)
│   │   └── resources/
│   │       └── application.properties
├── pom.xml
├── README.md
└── ...
```

> Projeto simples para fins de teste, estudo e aprendizado. Para dúvidas, entre em contato pelo [GitHub](https://github.com/johnsm1).
