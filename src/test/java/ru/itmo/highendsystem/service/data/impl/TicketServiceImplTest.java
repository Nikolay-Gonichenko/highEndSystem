package ru.itmo.highendsystem.service.data.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.itmo.highendsystem.mapper.TicketMapper;
import ru.itmo.highendsystem.model.dto.full.FullHumanDto;
import ru.itmo.highendsystem.model.dto.full.FullTicketDto;
import ru.itmo.highendsystem.model.entity.Human;
import ru.itmo.highendsystem.model.entity.Ticket;
import ru.itmo.highendsystem.repository.TicketRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TicketServiceImplTest {
    @Mock
    private TicketRepository ticketRepository;
    @Mock
    private TicketMapper ticketMapper;

    @InjectMocks
    private TicketServiceImpl ticketService;

    @Test
    public void getAllTicketByUserIdCorrectTest() {
        long user1Id = 1L;
        long user2Id = 2L;
        Human human1 = new Human();
        human1.setId(user1Id);
        Human human2 = new Human();
        human2.setId(user2Id);
        Ticket ticket1 = new Ticket();
        ticket1.setHuman(human1);
        FullHumanDto fullHumanDto1 = new FullHumanDto();
        fullHumanDto1.setId(user1Id);
        FullHumanDto fullHumanDto2 = new FullHumanDto();
        fullHumanDto2.setId(user2Id);
        FullTicketDto fullTicketDto1 = new FullTicketDto();
        fullTicketDto1.setHuman(fullHumanDto1);
        FullTicketDto fullTicketDto2 = new FullTicketDto();
        fullTicketDto2.setHuman(fullHumanDto2);
        List<Ticket> allTickets = List.of(ticket1);
        when(ticketRepository.findAllByHumanId(user1Id)).thenReturn(allTickets);
        when(ticketMapper.ticketToFullDto(ticket1)).thenReturn(fullTicketDto1);
        List<FullTicketDto> expectedResult = ticketService.getAllTicketsByUserId(user1Id);
        assertEquals(expectedResult.size(), 1);
        assertEquals(expectedResult.get(0).getHuman().getId(), user1Id);
    }
}
