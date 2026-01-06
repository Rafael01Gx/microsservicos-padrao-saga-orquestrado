package br.com.microservices.orchestrated.OrderService.config.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.kafka")
public record KafkaProperties(
        Topic topic,
        TopicConfig  topicConfig
) {
    public record Topic(
            String startSaga,
            String notifyEnding
    ) {}
    public record TopicConfig(
            Integer partitions,
            Integer replicas
    ) {}
}