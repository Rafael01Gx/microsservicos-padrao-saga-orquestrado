package br.com.microservices.orchestrated.OrderService.core.dto;

import br.com.microservices.orchestrated.OrderService.core.model.OrderProducts;
import lombok.Builder;

import java.util.List;

@Builder
public record OrderRequest(
        List<OrderProducts> products
) {
}
