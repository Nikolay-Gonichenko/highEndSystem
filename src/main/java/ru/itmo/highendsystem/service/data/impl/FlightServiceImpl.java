package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.FlightMapper;
import ru.itmo.highendsystem.model.dto.full.FullFlightDto;
import ru.itmo.highendsystem.model.entity.Flight;
import ru.itmo.highendsystem.repository.FlightRepository;
import ru.itmo.highendsystem.service.data.FlightService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализация {@link ru.itmo.highendsystem.service.data.FlightService}
 */
@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightMapper flightMapper;
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public FullFlightDto getFlightById(Long id) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(Flight.class, id));
        return flightMapper.flightToFullDto(flight);
    }

    @Override
    public List<FullFlightDto> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream().map(x -> flightMapper.flightToFullDto(x)).collect(Collectors.toList());
    }

    @Override
    public FullFlightDto saveFlight(FullFlightDto flight) {
        return flightMapper.flightToFullDto(
                flightRepository.save(flightMapper.fullDtoToFlight(flight))
        );
    }
}
