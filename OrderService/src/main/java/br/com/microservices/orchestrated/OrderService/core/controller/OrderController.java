package br.com.microservices.orchestrated.OrderService.core.controller;

import br.com.microservices.orchestrated.OrderService.core.dto.OrderRequest;
import br.com.microservices.orchestrated.OrderService.core.model.Order;
import br.com.microservices.orchestrated.OrderService.core.service.OrderService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;


    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody OrderRequest order){
        return ResponseEntity.ok(orderService.createOrder(order));
    }
}
