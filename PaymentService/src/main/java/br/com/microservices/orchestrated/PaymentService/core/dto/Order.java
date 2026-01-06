package br.com.microservices.orchestrated.PaymentService.core.dto;

import lombok.Builder;
import java.time.LocalDateTime;
import java.util.List;


@Builder
public record Order(
         String id,
         List<OrderProducts> products,
         LocalDateTime createdAt,
         String transactionId,
         Double totalAmount,
         Integer totalItems
) {}
