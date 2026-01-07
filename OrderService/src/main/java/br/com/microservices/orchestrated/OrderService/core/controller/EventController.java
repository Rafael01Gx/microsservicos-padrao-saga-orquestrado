package br.com.microservices.orchestrated.OrderService.core.controller;

import br.com.microservices.orchestrated.OrderService.core.dto.EventFilters;
import br.com.microservices.orchestrated.OrderService.core.model.Event;
import br.com.microservices.orchestrated.OrderService.core.service.EventService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<Event> findByFilters(EventFilters filters) {
        return ResponseEntity.ok().body(eventService.findByFilters(filters));
    }

    @GetMapping("all")
    public ResponseEntity<Page<Event>> findAll(@PageableDefault(page = 0,size = 10,sort = "createdAt",direction = Sort.Direction.DESC) Pageable  pageable) {
        return ResponseEntity.ok().body(eventService.findAll(pageable));
    }
}
