package br.com.microservices.orchestrated.PaymentService.core.messaging.out;

import br.com.microservices.orchestrated.PaymentService.config.kafka.KafkaProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaProperties kafkaProperties;

    public void sendEvent(String payload) {
        try {
            kafkaTemplate.send(kafkaProperties.topic().orchestrator(), payload);
            log.info("SagaProducer sending event to topic {} with data: {}", kafkaProperties.topic().orchestrator(), payload);

        } catch (Exception e) {
            log.error("Error trying to send data to topic {} with data {}", kafkaProperties.topic().orchestrator(), payload);
        }
    }
}
