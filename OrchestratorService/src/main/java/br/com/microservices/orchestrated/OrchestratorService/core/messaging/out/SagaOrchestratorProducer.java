package br.com.microservices.orchestrated.OrchestratorService.core.messaging.out;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class SagaOrchestratorProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;


    public void sendEvent(String payload,String topicName) {
        try {
            kafkaTemplate.send(topicName, payload);
            log.info("SagaProducer sending event to topic {} with data: {}", topicName, payload);

        } catch (Exception e) {
            log.error("Error trying to send data to topic {} with data {}", topicName, payload);
        }
    }
}
