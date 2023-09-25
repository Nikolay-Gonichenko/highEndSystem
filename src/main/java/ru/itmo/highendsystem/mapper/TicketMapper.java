package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullTicketDto;
import ru.itmo.highendsystem.model.entity.Ticket;

@Mapper(componentModel = "spring", uses = {FlightMapper.class, HumanMapper.class})
public interface TicketMapper {

    FullTicketDto ticketToFullDto(Ticket ticket);

    Ticket fullDtoToTicket(FullTicketDto ticketDto);
}
