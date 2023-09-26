package ru.itmo.highendsystem.service.business.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.itmo.highendsystem.exception.buisiness.IncorrectMoneyAmountException;
import ru.itmo.highendsystem.exception.buisiness.NotFoundEmptyTicketForPlaceException;
import ru.itmo.highendsystem.model.dto.full.FullHumanDto;
import ru.itmo.highendsystem.model.dto.full.FullTicketDto;
import ru.itmo.highendsystem.model.dto.partial.ShortTicketDto;
import ru.itmo.highendsystem.service.data.HumanService;
import ru.itmo.highendsystem.service.data.TicketService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TicketOperationServiceImplTest {
    @Mock
    private TicketService ticketService;
    @Mock
    private HumanService humanService;

    @InjectMocks
    private TicketOperationServiceImpl ticketOperationService;

    @Test
    public void buyTicketCorrectResult() {
        Long humanId = 1L;
        Long flightId = 1L;
        Integer cost = 100;
        String place = "10A";
        ShortTicketDto shortTicketDto = new ShortTicketDto(flightId, cost, place);
        FullTicketDto fullTicketDto = new FullTicketDto();
        Long ticketId = 1L;
        fullTicketDto.setId(ticketId);
        fullTicketDto.setHuman(null);
        fullTicketDto.setCost(cost);
        fullTicketDto.setPlace(place);
        when(ticketService.getAllTicketsByFlightId(flightId)).thenReturn(List.of(fullTicketDto));
        when(humanService.getHumanById(humanId)).thenReturn(new FullHumanDto());
        when(ticketService.saveTicket(fullTicketDto)).thenReturn(fullTicketDto);

        assertEquals(ticketOperationService.buyTicket(humanId, shortTicketDto), ticketId);
    }

    @Test
    public void buyTicketShouldThrowNotFoundEmptyTicketForPlaceExceptionTest() {
        Long humanId = 1L;
        Long flightId = 1L;
        Integer cost = 100;
        String place = "10A";
        ShortTicketDto shortTicketDto = new ShortTicketDto(flightId, cost, place);
        FullTicketDto fullTicketDto = new FullTicketDto();
        Long ticketId = 1L;
        fullTicketDto.setId(ticketId);
        fullTicketDto.setHuman(new FullHumanDto());
        fullTicketDto.setCost(cost);
        fullTicketDto.setPlace(place);
        when(ticketService.getAllTicketsByFlightId(flightId)).thenReturn(List.of(fullTicketDto));

        assertThrows(NotFoundEmptyTicketForPlaceException.class,
                () -> ticketOperationService.buyTicket(humanId, shortTicketDto));
    }

    @Test
    public void buyTicketShouldThrowIncorrectMoneyAmountExceptionTest() {
        Long humanId = 1L;
        Long flightId = 1L;
        Integer cost = 100;
        String place = "10A";
        ShortTicketDto shortTicketDto = new ShortTicketDto(flightId, cost, place);
        FullTicketDto fullTicketDto = new FullTicketDto();
        Long ticketId = 1L;
        fullTicketDto.setId(ticketId);
        fullTicketDto.setHuman(null);
        fullTicketDto.setCost(cost * 2);
        fullTicketDto.setPlace(place);
        when(ticketService.getAllTicketsByFlightId(flightId)).thenReturn(List.of(fullTicketDto));

        assertThrows(IncorrectMoneyAmountException.class,
                () -> ticketOperationService.buyTicket(humanId, shortTicketDto));
    }
}
