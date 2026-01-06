package br.com.microservices.orchestrated.PaymentService.core.dto;


import br.com.microservices.orchestrated.PaymentService.core.enums.ESagaStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record History(
        String source,
        ESagaStatus status,
        String message,
        LocalDateTime createdAt
) { }
