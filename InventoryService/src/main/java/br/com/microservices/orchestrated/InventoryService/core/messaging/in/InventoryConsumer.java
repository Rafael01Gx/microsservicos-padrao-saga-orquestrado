package br.com.microservices.orchestrated.InventoryService.core.messaging.in;


import br.com.microservices.orchestrated.InventoryService.core.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class InventoryConsumer {

    private final JsonUtil jsonUtil;

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "${app.kafka.topic.inventory-success}"
    )
    public void consumeSuccessEvent(String payload) {
        log.info("Consume success event received: {}", payload);
        var event = jsonUtil.toEvent(payload);
    }

    @KafkaListener(
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "${app.kafka.topic.inventory-fail}"
    )
    public void consumeFailEvent(String payload) {
        log.info("Consume rollback event received: {}", payload);
        var event = jsonUtil.toEvent(payload);
    }

}
