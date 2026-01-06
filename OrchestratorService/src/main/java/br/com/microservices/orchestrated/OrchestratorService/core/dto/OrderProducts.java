package br.com.microservices.orchestrated.OrchestratorService.core.dto;

import lombok.Builder;

@Builder
public record OrderProducts(
        Product product,
        Integer quantity
) { }
