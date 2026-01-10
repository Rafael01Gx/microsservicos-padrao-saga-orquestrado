# Configurações Kafka para Aplicações Spring Boot (Producer & Consumer)

Este documento descreve **configurações modernas, completas e recomendadas para PRODUCER e CONSUMER Kafka em aplicações Spring Boot**, focado **exclusivamente no lado da aplicação**, **não na infraestrutura do cluster Kafka**.

---

## 🎯 Objetivo

- Garantir **confiabilidade**
- Garantir **performance**
- Garantir **segurança**
- Garantir **observabilidade**
- Ser adequado para **ambiente de produção**
- Aplicável a **arquiteturas orientadas a eventos e Saga Pattern**

---

## 📌 Configuração Base

```yaml
spring:
  kafka:
    bootstrap-servers: kafka1:9092,kafka2:9092
```

### 🔹 bootstrap-servers
- Lista de brokers Kafka
- Usado apenas para **descoberta inicial**
- Em produção, sempre informe **mais de um broker**

---

## 🟢 CONFIGURAÇÕES DO PRODUCER

```yaml
spring:
  kafka:
    producer:
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
```

### 🔹 Serializers
- Responsáveis por transformar objetos Java em bytes
- Produção moderna costuma usar:
  - `StringSerializer`
  - `JsonSerializer`
  - `Avro / Protobuf` (ambientes enterprise)

---

### 🔐 Garantia de Entrega

```yaml
spring:
  kafka:
    producer:
      acks: all
```

| Valor | Significado |
|-----|------------|
| 0 | Não aguarda confirmação |
| 1 | Aguarda líder |
| all | Aguarda todas as réplicas (recomendado) |

✔️ **Produção:** `acks=all`

---

### 🔁 Reenvio e Idempotência

```yaml
spring:
  kafka:
    producer:
      retries: 10
      enable-idempotence: true
```

- Evita mensagens duplicadas
- Fundamental para **Saga Pattern**
- Ativa automaticamente:
  - `acks=all`
  - `max.in.flight.requests.per.connection <= 5`

---

### ⚡ Performance do Producer

```yaml
spring:
  kafka:
    producer:
      linger-ms: 5
      batch-size: 32768
      compression-type: snappy
```

| Propriedade | Função |
|-----------|-------|
| linger-ms | Espera para agrupar mensagens |
| batch-size | Tamanho do lote |
| compression-type | Compressão (snappy, gzip, lz4) |

✔️ **snappy** é o melhor custo-benefício

---

## 🔵 CONFIGURAÇÕES DO CONSUMER

```yaml
spring:
  kafka:
    consumer:
      group-id: product-validation-service-group
```

### 🔹 group-id
- Define o **grupo de consumo**
- Cada partição é lida por **apenas um consumer do grupo**
- Essencial para escalabilidade

---

### 🔄 Controle de Offset

```yaml
spring:
  kafka:
    consumer:
      enable-auto-commit: false
```

✔️ **Produção:** desabilitar auto commit  
✔️ Commit manual após processamento bem-sucedido

---

### ⏱️ Política de Offset Inicial

```yaml
spring:
  kafka:
    consumer:
      auto-offset-reset: latest
```

| Valor | Comportamento |
|-----|---------------|
| earliest | Lê desde o início |
| latest | Lê mensagens novas |
| none | Erro se não houver offset |

✔️ Microserviços novos → `earliest`  
✔️ Serviços contínuos → `latest`

---

### 🧠 Performance do Consumer

```yaml
spring:
  kafka:
    consumer:
      max-poll-records: 500
      fetch-min-size: 1024
      fetch-max-wait: 500
```

---

## 🔁 CONTROLE DE ERROS E RETRY

```yaml
spring:
  kafka:
    listener:
      ack-mode: manual
```

---

## ☠️ DEAD LETTER TOPIC (DLT)

Boa prática:
```
<topic>.DLT
```

---

## 🔐 SEGURANÇA (Aplicação)

```yaml
spring:
  kafka:
    properties:
      security.protocol: SASL_SSL
      sasl.mechanism: SCRAM-SHA-512
```

---

## 👀 OBSERVABILIDADE

```yaml
logging:
  level:
    org.apache.kafka: INFO
    org.springframework.kafka: INFO
```

---

## 🧩 CONFIGURAÇÃO IDEAL PARA SAGA PATTERN

```yaml
spring:
  kafka:
    producer:
      acks: all
      enable-idempotence: true
    consumer:
      enable-auto-commit: false
      isolation-level: read_committed
```

---

## 🚫 O QUE NÃO FAZER

❌ Não usar `@Transactional` com Kafka  
❌ Não confiar em auto-commit  
❌ Não usar `acks=1` em produção  

---

## ✅ CHECKLIST FINAL

✔ acks=all  
✔ enable-idempotence=true  
✔ auto-commit=false  
✔ DLT configurado  

---

## 🏁 Conclusão

Configurar corretamente Kafka **no lado da aplicação** é essencial para sistemas distribuídos robustos.
