package br.com.microservices.orchestrated.InventoryService.core.dto;

import lombok.Builder;

@Builder
public record Product (
         String code,
         Double unitValue
){ }
