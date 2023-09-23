package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.FlightMapper;
import ru.itmo.highendsystem.model.dto.full.FullFlightDto;
import ru.itmo.highendsystem.model.entity.Flight;
import ru.itmo.highendsystem.repository.FlightRepository;
import ru.itmo.highendsystem.service.data.FlightService;

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
}
