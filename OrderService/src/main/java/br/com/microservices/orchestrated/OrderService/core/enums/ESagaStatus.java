package br.com.microservices.orchestrated.OrderService.core.enums;

public enum ESagaStatus {
    SUCCESS,
    ROLLBACK_PENDING,
    FAILL,
}
