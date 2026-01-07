package br.com.microservices.orchestrated.OrderService.core.service;

import br.com.microservices.orchestrated.OrderService.config.exception.ValidationException;
import br.com.microservices.orchestrated.OrderService.core.dto.EventFilters;
import br.com.microservices.orchestrated.OrderService.core.model.Event;
import br.com.microservices.orchestrated.OrderService.core.repository.EventRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class EventService {

    private final EventRepository eventRepository;

    public void notifyEnding(Event event){
        save(event);
        log.info("Event {} has been notified! TransactionId: {}", event, event.getTransactionId());
    }

    public Event save(Event event) {
        return eventRepository.save(event);
    }

    public Page<Event> findAll(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    public Event findByFilters(EventFilters filters) {
        if (!filters.orderId().isEmpty()) {
           return findByOrderId(filters.orderId());
        } else {
        return findByTransactionId(filters.transactionId());
        }
    }

    private Event findByOrderId(String orderId) {
        return eventRepository.findTop1ByOrderId(orderId)
                .orElseThrow(ValidationException::eventNotFound);
    }
    private Event findByTransactionId(String orderId) {
        return eventRepository.findTop1ByTransactionId(orderId)
                .orElseThrow(ValidationException::eventNotFound);
    }
}
