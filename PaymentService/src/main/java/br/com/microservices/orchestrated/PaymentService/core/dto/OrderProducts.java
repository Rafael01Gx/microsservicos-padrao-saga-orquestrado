package br.com.microservices.orchestrated.PaymentService.core.dto;

import lombok.Builder;

@Builder
public record OrderProducts(
        Product product,
        Integer quantity
) { }
