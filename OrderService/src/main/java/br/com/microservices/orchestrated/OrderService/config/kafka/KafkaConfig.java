package br.com.microservices.orchestrated.OrderService.config.kafka;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(KafkaProperties.class)
@Profile("dev")
public class KafkaConfig {

    private final KafkaProperties kafkaProperties;


    private NewTopic buildTopic(String topicName) {
        return TopicBuilder
                .name(topicName)
                .partitions(kafkaProperties.topicConfig().partitions())
                .replicas(kafkaProperties.topicConfig().replicas())
                .build();
    }

    @Bean
    public NewTopic startSagaTopic(){
        return buildTopic(kafkaProperties.topic().startSaga());
    }
    @Bean
    public NewTopic notifyEnding(){
        return buildTopic(kafkaProperties.topic().notifyEnding());
    }
}
