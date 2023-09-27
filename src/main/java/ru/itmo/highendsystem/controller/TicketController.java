package ru.itmo.highendsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.highendsystem.model.dto.partial.ShortTicketDto;
import ru.itmo.highendsystem.service.business.TicketOperationService;

@RestController
@RequestMapping("api/v1/airline/tickets")
public class TicketController {

    @Autowired
    TicketOperationService ticketOperationService;

    @PostMapping("buy")
    public ResponseEntity<Long> buyTicket(Long humanId, ShortTicketDto ticket) {
        return ResponseEntity.ok(ticketOperationService.buyTicket(humanId, ticket));
    }

    @PostMapping("cost")
    public ResponseEntity<Integer> setCostOnTickets(Long flightId, Integer cost) {
        return ResponseEntity.ok(ticketOperationService.setCostOnTickets(flightId, cost));
    }
}
