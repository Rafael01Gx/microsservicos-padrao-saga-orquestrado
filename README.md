# Arquitetura de Microsserviços: Padrão Saga Orquestrado

![Java](https://img.shields.io/badge/Java-25-red)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0-brightgreen)
![Kafka](https://img.shields.io/badge/Apache%20Kafka-Event%20Driven-black)
![Docker](https://img.shields.io/badge/Docker-Containerization-blue)
![Status](https://img.shields.io/badge/Status-Study%20Project-yellow)

Este repositório documenta **estudos práticos em Arquitetura de Microsserviços**, com foco no **Padrão Saga Orquestrado**, utilizado para garantir consistência de dados em sistemas distribuídos baseados em eventos.

O objetivo é **didático e exploratório**, não representando um ambiente produtivo.

---

## 📑 Sumário

- [Visão Geral](#-visão-geral)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Arquitetura da Solução](#-arquitetura-da-solução)
- [Serviços da Arquitetura](#-serviços-da-arquitetura)
- [Execução do Projeto](#-execução-do-projeto)
- [Acesso](#-acesso)
- [Observações](#-observações)

---

## 🔍 Visão Geral

O padrão **Saga Orquestrado** coordena transações distribuídas por meio de um **serviço central de orquestração**, responsável por controlar o fluxo, estados e compensações entre microsserviços.

---

## 🚀 Tecnologias Utilizadas

- **Java 25**
- **Spring Boot 4.0**
- **Apache Kafka**
- **API REST**
- **PostgreSQL**
- **MongoDB**
- **Docker**
- **Docker Compose**
- **Redpanda Console**

---

## 🧱 Arquitetura da Solução

A arquitetura abaixo substitui diagramas estáticos tradicionais, utilizando **Mermaid**, o que permite versionamento, melhor leitura e renderização nativa no GitHub.

```mermaid
flowchart LR
    subgraph Client Layer
        Order["Order Service (Spring Boot)"]
    end

    subgraph Orchestration Layer
        Orchestrator["Orchestrator Service Saga Controller"]
    end

    subgraph Messaging Layer
        Kafka[(Apache Kafka)]
    end

    subgraph Business Services
        Product[Product Validation Service]
        Payment[Payment Service]
        Inventory[Inventory Service]
    end

    subgraph Data Layer
        Mongo[(MongoDB\norder-db)]
        PDB[(PostgreSQL\nproduct-db)]
        PayDB[(PostgreSQL\npayment-db)]
        InvDB[(PostgreSQL\ninventory-db)]
    end

    Order -->|Start Saga| Orchestrator
    Orchestrator --> Kafka

    Kafka --> Product
    Kafka --> Payment
    Kafka --> Inventory

    Product -->|Success / Fail| Kafka
    Payment -->|Success / Fail| Kafka
    Inventory -->|Success / Fail| Kafka

    Kafka --> Orchestrator
    Orchestrator -->|End Saga| Order

    Order --> Mongo
    Product --> PDB
    Payment --> PayDB
    Inventory --> InvDB
```

---

## 🧩 Serviços da Arquitetura

- **Order-Service**  
  Inicia a saga e expõe endpoints REST.  
  Banco: MongoDB

- **Orchestrator-Service**  
  Controla estados, sequência e compensações da saga.  
  Banco: N/A

- **Product-Validation-Service**  
  Valida produtos do pedido.  
  Banco: PostgreSQL

- **Payment-Service**  
  Processa pagamentos.  
  Banco: PostgreSQL

- **Inventory-Service**  
  Controla estoque.  
  Banco: PostgreSQL

---

## ▶️ Execução do Projeto

```bash
docker-compose up --build -d
```

Requisitos:
- Docker
- Java 25
- Gradle 8+

---

## 🌐 Acesso

- Swagger (Order-Service): http://localhost:3000/swagger-ui.html
- Redpanda Console: http://localhost:8081

---

## ⚠️ Observações

- Projeto com foco **educacional**
- Estrutura voltada para compreensão do padrão Saga
- Não indicado para produção sem ajustes arquiteturais

---

## 👤 Autor

**Rafael Junio Moraes**  
Desenvolvedor Back-End / Full-Stack  
