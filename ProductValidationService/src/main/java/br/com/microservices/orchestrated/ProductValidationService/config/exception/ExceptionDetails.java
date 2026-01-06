package br.com.microservices.orchestrated.ProductValidationService.config.exception;

import java.io.Serializable;

public record ExceptionDetails(int code, String message) implements Serializable {
}
