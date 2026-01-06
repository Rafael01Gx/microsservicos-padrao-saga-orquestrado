package br.com.microservices.orchestrated.PaymentService.config.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "app.kafka")
public record KafkaProperties(
        Topic topic,
        TopicConfig topicConfig
) {
    public record Topic(
            String paymentSuccess,
            String paymentFail,
            String orchestrator
    ) {}

    public record TopicConfig(
            Integer partitions,
            Integer replicas
    ) {}
}