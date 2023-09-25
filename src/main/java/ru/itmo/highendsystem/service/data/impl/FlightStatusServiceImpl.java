package ru.itmo.highendsystem.service.data.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.data.NotFoundEntityByIdException;
import ru.itmo.highendsystem.mapper.FlightStatusMapper;
import ru.itmo.highendsystem.model.dto.full.FullFlightStatusDto;
import ru.itmo.highendsystem.model.entity.FlightStatus;
import ru.itmo.highendsystem.repository.FlightStatusRepository;
import ru.itmo.highendsystem.service.data.FlightStatusService;

@Service
public class FlightStatusServiceImpl implements FlightStatusService {

    @Autowired
    FlightStatusMapper flightStatusMapper;
    @Autowired
    FlightStatusRepository flightStatusRepository;
    @Override
    public FullFlightStatusDto getFlightStatusById(Long id) {
        FlightStatus flightStatus = flightStatusRepository.findById(id)
                .orElseThrow(() -> new NotFoundEntityByIdException(FlightStatus.class, id));
        return flightStatusMapper.flightStatusToFullDto(flightStatus);
    }
}
