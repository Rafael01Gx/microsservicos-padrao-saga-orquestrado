package br.com.microservices.orchestrated.PaymentService.config.exception;

import java.io.Serializable;

public record ExceptionDetails(int code, String message) implements Serializable {
}
