package br.com.microservices.orchestrated.OrchestratorService.core.dto;

import br.com.microservices.orchestrated.OrchestratorService.core.enums.EEventSource;
import br.com.microservices.orchestrated.OrchestratorService.core.enums.ESagaStatus;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record History(
        EEventSource source,
        ESagaStatus status,
        String message,
        LocalDateTime createdAt
) { }
