package br.com.microservices.orchestrated.OrchestratorService.config.kafka;

import br.com.microservices.orchestrated.OrchestratorService.core.enums.ETopics;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin.NewTopics;

import java.util.Arrays;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(KafkaProperties.class)
@Profile("dev")
public class KafkaConfig {

    private final KafkaProperties kafkaProperties;

    @Bean
    public NewTopics sagaTopics(){
        return new NewTopics(
                Arrays.stream(ETopics.values())
                        .map(this::buildTopic)
                        .toArray(NewTopic[]::new)
        );
    }


    private NewTopic buildTopic(ETopics topic) {
        return TopicBuilder
                .name(topic.getTopic())
                .partitions(kafkaProperties.topicConfig().partitions())
                .replicas(kafkaProperties.topicConfig().replicas())
                .build();
    }
}
