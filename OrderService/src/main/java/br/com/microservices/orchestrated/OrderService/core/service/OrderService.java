package br.com.microservices.orchestrated.OrderService.core.service;

import br.com.microservices.orchestrated.OrderService.core.dto.OrderRequest;
import br.com.microservices.orchestrated.OrderService.core.messaging.out.SagaProducer;
import br.com.microservices.orchestrated.OrderService.core.model.Event;
import br.com.microservices.orchestrated.OrderService.core.model.Order;
import br.com.microservices.orchestrated.OrderService.core.repository.OrderRepository;
import br.com.microservices.orchestrated.OrderService.core.utils.JsonUtil;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

    private final SagaProducer producer;
    private final EventService eventService;
    private final OrderRepository orderRepository;
    private final JsonUtil jsonUtil;

    public Order createOrder(OrderRequest orderRequest) {
        var order = Order
                .builder()
                .products(orderRequest.products())
                .transactionId(newTransactionId())
                .build();
       orderRepository.save(order);
       producer.sendEvent(
               jsonUtil.toJson(createPayload(order)));

        return order;
    }

    private Event createPayload(Order order) {
        var event = Event
                .builder()
                .orderId(order.getId())
                .transactionId(order.getTransactionId())
                .payload(order)
                .build();
        eventService.save(event);
        return event;
    }


    private String newTransactionId(){
        return String.format("%s_%s", Instant.now().toEpochMilli(), UUID.randomUUID().toString());
    }
}
