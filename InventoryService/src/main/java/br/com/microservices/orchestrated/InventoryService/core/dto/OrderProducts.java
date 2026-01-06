package br.com.microservices.orchestrated.InventoryService.core.dto;

import lombok.Builder;

@Builder
public record OrderProducts(
        Product product,
        Integer quantity
) { }
