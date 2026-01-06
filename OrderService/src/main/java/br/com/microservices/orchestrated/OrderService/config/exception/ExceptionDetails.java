package br.com.microservices.orchestrated.OrderService.config.exception;

import java.io.Serializable;

public record ExceptionDetails(int code, String message) implements Serializable {
}
