package br.com.microservices.orchestrated.ProductValidationService.core.dto;


import br.com.microservices.orchestrated.ProductValidationService.core.enums.ESagaStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record History(
        String source,
        ESagaStatus status,
        String message,
        LocalDateTime createdAt
) { }
