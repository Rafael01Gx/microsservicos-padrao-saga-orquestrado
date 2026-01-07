package br.com.microservices.orchestrated.OrderService.core.repository;

import br.com.microservices.orchestrated.OrderService.core.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order,String> {
}
