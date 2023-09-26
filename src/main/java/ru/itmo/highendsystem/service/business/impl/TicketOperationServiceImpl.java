package ru.itmo.highendsystem.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.buisiness.IncorrectMoneyAmountException;
import ru.itmo.highendsystem.exception.buisiness.NotFoundEmptyTicketForPlaceException;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.model.dto.full.FullTicketDto;
import ru.itmo.highendsystem.model.dto.partial.ShortTicketDto;
import ru.itmo.highendsystem.model.entity.Ticket;
import ru.itmo.highendsystem.service.business.TicketOperationService;
import ru.itmo.highendsystem.service.data.HumanService;
import ru.itmo.highendsystem.service.data.TicketService;

import java.util.List;
import java.util.Objects;

/**
 * Реализация {@link TicketOperationService}
 */
@Service
public class TicketOperationServiceImpl implements TicketOperationService {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private HumanService humanService;

    @Override
    public Long buyTicket(Long humanId, ShortTicketDto ticket) {
        FullTicketDto ticketDto = ticketService.getAllTicketsByFlightId(ticket.flight())
                .stream()
                .filter(x -> x.getHuman() == null && Objects.equals(x.getPlace(), ticket.place()))
                .findFirst()
                .orElseThrow(() -> new NotFoundEmptyTicketForPlaceException(ticket.flight(), ticket.place()));
        if (ticket.cost() != ticketDto.getCost()) {
            throw new IncorrectMoneyAmountException(ticketDto.getCost(), ticket.cost());
        }
        ticketDto.setHuman(humanService.getHumanById(humanId));
        return ticketService.saveTicket(ticketDto).getId();
    }

    @Override
    public Integer setCostOnTickets(Long flightId, Integer cost) {
        List<FullTicketDto> flightTickets = ticketService.getAllTicketsByFlightId(flightId);
        for (FullTicketDto flightTicket : flightTickets) {
            flightTicket.setCost(cost);
        }
        return ticketService.saveAllTickets(flightTickets);
    }
}
