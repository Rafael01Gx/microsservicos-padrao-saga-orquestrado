package br.com.microservices.orchestrated.InventoryService.core.dto;


import br.com.microservices.orchestrated.InventoryService.core.enums.ESagaStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record History(
        String source,
        ESagaStatus status,
        String message,
        LocalDateTime createdAt
) { }
