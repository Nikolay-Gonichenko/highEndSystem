package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.mapper.TicketMapper;
import ru.itmo.highendsystem.model.dto.full.FullTicketDto;
import ru.itmo.highendsystem.model.entity.Ticket;
import ru.itmo.highendsystem.repository.TicketRepository;
import ru.itmo.highendsystem.service.data.TicketService;

import java.util.List;

/**
 * Реализация {@link ru.itmo.highendsystem.service.data.TicketService}
 */
@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private TicketMapper ticketMapper;

    @Override
    public List<FullTicketDto> getAllTicketByUserId(long id) {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets.stream()
                .filter(x -> x.getHuman().getId() == id)
                .map(x -> ticketMapper.ticketToFullDto(x)).toList();
    }
}
