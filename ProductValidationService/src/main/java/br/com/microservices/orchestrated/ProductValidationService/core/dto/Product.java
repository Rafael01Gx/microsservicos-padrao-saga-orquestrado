package br.com.microservices.orchestrated.ProductValidationService.core.dto;

import lombok.Builder;

@Builder
public record Product (
         String code,
         Double unitValue
){ }
