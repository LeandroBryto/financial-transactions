# Transação 

A **Transação** é uma aplicação construída com o objetivo de gerenciar transações financeiras, permitindo adicionar, consultar e excluir transações, bem como calcular estatísticas dessas transações.

## Tecnologias Utilizadas

- **Java 17**: A linguagem de programação utilizada para o desenvolvimento da API.
- **Spring Boot 3.4.2**: Framework utilizado para criar a aplicação de forma eficiente, com foco em microserviços.
- **Spring Web**: Responsável pela criação dos endpoints REST.
- **Spring Actuator**: Para monitoramento da aplicação.
- **Swagger (OpenAPI)**: Usado para gerar a documentação interativa da API.
- **Lombok**: Para reduzir a verbosidade do código e gerar automaticamente getters, setters, `toString`, `hashCode`, `equals` e outros.


## Endpoints

### /transacao

#### **POST** `/transacao`
- **Descrição**: Adiciona uma nova transação.
- **Corpo da requisição** (JSON):
    ```json
    {
      "valor": 100.0,
      "dataHora": "2025-02-01T14:00:00+00:00"
    }
    ```
- **Respostas**:
  - `201 Created`: Transação gravada com sucesso.
  - `422 Unprocessable Entity`: Campos não atendem aos requisitos.
  - `400 Bad Request`: Erro de requisição.
  - `500 Internal Server Error`: Erro interno do servidor.

#### **DELETE** `/transacao`
- **Descrição**: Deleta todas as transações.
- **Respostas**:
  - `200 OK`: Transações deletadas com sucesso.
  - `400 Bad Request`: Erro de requisição.
  - `500 Internal Server Error`: Erro interno do servidor.

### /estatistica

#### **GET** `/estatistica`
- **Descrição**: Retorna as estatísticas das transações, incluindo a quantidade, soma, média, valor mínimo e máximo.
- **Parâmetros**:
  - `intervaloBusca` (opcional): Tempo em segundos para buscar as transações. O valor padrão é `60` segundos.
- **Respostas**:
  - `200 OK`: Estatísticas retornadas com sucesso.
  - `400 Bad Request`: Erro de requisição.
  - `500 Internal Server Error`: Erro interno do servidor.


