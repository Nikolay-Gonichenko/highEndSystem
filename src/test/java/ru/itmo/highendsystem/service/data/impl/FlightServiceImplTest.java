package ru.itmo.highendsystem.service.data.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.FlightMapper;
import ru.itmo.highendsystem.model.dto.full.FullFlightDto;
import ru.itmo.highendsystem.model.entity.Flight;
import ru.itmo.highendsystem.repository.FlightRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FlightServiceImplTest {
    @Mock
    private FlightMapper flightMapper;
    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightServiceImpl flightService;

    @Test
    public void getFlightByIdCorrectTest() {
        long id = 1L;
        Flight flight = new Flight();
        flight.setId(id);
        when(flightRepository.findById(id)).thenReturn(Optional.of(flight));
        FullFlightDto fullFlightDto = new FullFlightDto();
        fullFlightDto.setId(id);
        when(flightMapper.flightToFullDto(flight)).thenReturn(fullFlightDto);

        FullFlightDto expected = flightService.getFlightById(id);
        assertEquals(expected.getId(), id);
    }

    @Test
    public void getFlightByIdShouldThrowException() {
        long id = 1L;
        when(flightRepository.findById(id)).thenReturn(Optional.empty());
        assertThrows(NotFoundEntityByIdException.class,
                () -> flightService.getFlightById(id));
    }

    @Test
    public void getAllFlightsTest() {
        long id1 = 1L;
        long id2 = 2L;
        Flight flight1 = new Flight();
        flight1.setId(id1);
        Flight flight2 = new Flight();
        flight2.setId(id2);
        FullFlightDto fullFlightDto1 = new FullFlightDto();
        fullFlightDto1.setId(id1);
        FullFlightDto fullFlightDto2 = new FullFlightDto();
        fullFlightDto2.setId(id2);
        List<Flight> flights = List.of(flight1, flight2);
        PageRequest pageRequest = PageRequest.of(0, 2);

        when(flightRepository.findAll(pageRequest)).thenReturn(new PageImpl<>(flights, pageRequest, flights.size()));
        when(flightMapper.flightToFullDto(flight1)).thenReturn(fullFlightDto1);
        when(flightMapper.flightToFullDto(flight2)).thenReturn(fullFlightDto2);

        List<FullFlightDto> expected = flightService.getAllFlights(0, 2);
        assertEquals(expected.size(), 2);
        assertEquals(expected.get(0).getId(), id1);
        assertEquals(expected.get(1).getId(), id2);
    }
}
