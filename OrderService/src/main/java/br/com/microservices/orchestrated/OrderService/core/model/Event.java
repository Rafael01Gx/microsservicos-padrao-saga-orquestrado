package br.com.microservices.orchestrated.OrderService.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "events")
public class Event {

    @Id
    private String id;
    @Indexed(unique = true)
    private String transactionId;
    @Indexed(unique = true)
    private String orderId;
    private Order payload;
    private String source;
    private String status;
    private List<History> eventHistory;
    @CreatedDate
    private LocalDateTime createdAt;
}
