package br.com.microservices.orchestrated.ProductValidationService.config.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.kafka")
public record KafkaProperties(
        String bootstrapServers,
        Topic topic,
        Consumer consumer,
        TopicConfig topicConfig

) {
    public record Topic(
            String productValidationSuccess,
            String productValidationFail,
            String orchestrator
    ) {}

    public record Consumer(
            String groupId,
            String autoOffsetReset
    ) {}

    public record TopicConfig(
            Integer partitions,
            Integer replicas
    ) {}
}