package br.com.microservices.orchestrated.ProductValidationService.core.dto;


import br.com.microservices.orchestrated.ProductValidationService.core.enums.ESagaStatus;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record Event(
         String id,
         String transactionId,
         String orderId,
         Order payload,
         String source,
         ESagaStatus status,
         List<History> eventHistory,
         LocalDateTime createdAt
) { }
