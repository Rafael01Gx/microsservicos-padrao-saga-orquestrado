package br.com.microservices.orchestrated.ProductValidationService.core.dto;

import lombok.Builder;

@Builder
public record OrderProducts(
        Product product,
        Integer quantity
) { }
