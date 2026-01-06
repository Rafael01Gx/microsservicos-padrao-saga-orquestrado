package br.com.microservices.orchestrated.OrchestratorService.core.dto;

import lombok.Builder;

@Builder
public record Product (
         String code,
         Double unitValue
){ }
