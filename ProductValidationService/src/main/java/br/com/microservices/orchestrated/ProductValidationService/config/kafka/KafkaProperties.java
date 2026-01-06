package br.com.microservices.orchestrated.ProductValidationService.config.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.kafka")
public record KafkaProperties(
        Topic topic,
        TopicConfig topicConfig

) {
    public record Topic(
            String productValidationSuccess,
            String productValidationFail,
            String orchestrator
    ) {}

    public record TopicConfig(
            Integer partitions,
            Integer replicas
    ) {}
}