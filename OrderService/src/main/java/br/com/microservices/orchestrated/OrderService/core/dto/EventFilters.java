package br.com.microservices.orchestrated.OrderService.core.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;

@Builder
public record EventFilters(
        String orderId,
        String transactionId
) {
}
