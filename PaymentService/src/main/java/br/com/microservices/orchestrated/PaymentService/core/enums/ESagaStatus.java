package br.com.microservices.orchestrated.PaymentService.core.enums;

public enum ESagaStatus {
    SUCCESS,
    ROLLBACK_PENDING,
    FAILL,
}
