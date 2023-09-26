package ru.itmo.highendsystem.service.business.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.itmo.highendsystem.model.dto.full.FullFlightDto;
import ru.itmo.highendsystem.model.dto.full.FullLocationDto;
import ru.itmo.highendsystem.model.dto.full.FullRouteDto;
import ru.itmo.highendsystem.model.dto.full.FullTicketDto;
import ru.itmo.highendsystem.service.data.TicketService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RecommendationServiceImplTest {
    @Mock
    private TicketService ticketService;

    @InjectMocks
    private RecommendationServiceImpl recommendationService;

    @Test
    public void getRecommendationsToUserWhenUserHadFlights() {
        long id = 1L;
        int count = 2;
        FullRouteDto routeDto1 = new FullRouteDto();
        routeDto1.setId(1L);
        routeDto1.setFromLocation(new FullLocationDto(1L, "country1", "city1",  null));
        routeDto1.setToLocation(new FullLocationDto(2L, "country2", "city2", null));
        FullRouteDto routeDto2 = new FullRouteDto();
        routeDto2.setId(2L);
        routeDto2.setFromLocation(new FullLocationDto(3L, "country3", "city3", null));
        routeDto2.setToLocation(new FullLocationDto(4L, "country4", "city4", null));
        FullFlightDto fullFlightDto1 = new FullFlightDto();
        fullFlightDto1.setId(1L);
        fullFlightDto1.setRoute(routeDto1);
        FullFlightDto fullFlightDto2 = new FullFlightDto();
        fullFlightDto2.setId(2L);
        fullFlightDto2.setRoute(routeDto2);
        FullTicketDto ticketDto1 = new FullTicketDto();
        ticketDto1.setId(1L);
        ticketDto1.setFlight(fullFlightDto1);
        FullTicketDto ticketDto2 = new FullTicketDto();
        ticketDto2.setId(2L);
        ticketDto2.setFlight(fullFlightDto2);
        when(ticketService.getAllTicketsByUserId(id)).thenReturn(List.of(ticketDto1, ticketDto2));

        List<FullRouteDto> expected = recommendationService.getRecommendationsToUser(id, count);
        assertEquals(expected, List.of(routeDto2, routeDto1));
    }
}
