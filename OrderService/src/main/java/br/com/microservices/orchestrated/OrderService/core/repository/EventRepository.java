package br.com.microservices.orchestrated.OrderService.core.repository;

import br.com.microservices.orchestrated.OrderService.core.model.Event;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface EventRepository extends MongoRepository<Event, String> {


    Optional<Event> findTop1ByOrderIdOrTransactionId(String orderId, String transactionId);

    Optional<Event> findTop1ByOrderId(@NotEmpty String s);

    Optional<Event> findTop1ByTransactionId(@NotEmpty String s);
}
