package ru.itmo.highendsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itmo.highendsystem.model.dto.partial.BuyingTicketDto;
import ru.itmo.highendsystem.model.dto.partial.SettingCostDto;
import ru.itmo.highendsystem.model.dto.partial.ShortTicketDto;
import ru.itmo.highendsystem.service.business.TicketOperationService;

@RestController
@RequestMapping("api/v1/airline/tickets")
public class TicketController {

    @Autowired
    TicketOperationService ticketOperationService;

    @PostMapping("buy")
    public ResponseEntity<Long> buyTicket(@RequestBody BuyingTicketDto buyingDto) {
        return ResponseEntity.ok(ticketOperationService.buyTicket(buyingDto.humanId(), buyingDto.ticketDto()));
    }

    @PostMapping("cost")
    public ResponseEntity<Integer> setCostOnTickets(@RequestBody SettingCostDto costDto) {
        return ResponseEntity.ok(ticketOperationService.setCostOnTickets(costDto.flightId(), costDto.cost()));
    }
}
