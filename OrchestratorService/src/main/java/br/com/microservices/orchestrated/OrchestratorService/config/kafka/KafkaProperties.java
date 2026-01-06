package br.com.microservices.orchestrated.OrchestratorService.config.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.kafka")
public record KafkaProperties(
        TopicConfig topicConfig
) {

    public record TopicConfig(
            Integer partitions,
            Integer replicas
    ) {}
}