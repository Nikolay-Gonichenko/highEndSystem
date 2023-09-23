package ru.itmo.highendsystem.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itmo.highendsystem.exception.buisiness.FlightIsNotInPreparedStatusException;
import ru.itmo.highendsystem.model.dto.full.FullCrewDto;
import ru.itmo.highendsystem.model.dto.full.FullEmployeeDto;
import ru.itmo.highendsystem.model.dto.full.FullFlightDto;
import ru.itmo.highendsystem.model.dto.partial.ShortCrewDto;
import ru.itmo.highendsystem.model.enums.FlightStatusEnum;
import ru.itmo.highendsystem.service.business.CrewManagementService;
import ru.itmo.highendsystem.service.data.CrewService;
import ru.itmo.highendsystem.service.data.EmployeeService;
import ru.itmo.highendsystem.service.data.FlightService;

/**
 * Реализация {@link CrewManagementService}
 */
@Service
public class CrewManagementServiceImpl implements CrewManagementService {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private FlightService flightService;
    @Autowired
    private CrewService crewService;


    @Override
    public Boolean addEmployeeToFlight(ShortCrewDto crewDto) {
        FullEmployeeDto fullEmployeeDto = employeeService.getById(crewDto.employeeId());
        FullFlightDto fullFlightDto = flightService.getFlightById(crewDto.flightId());

        if (!fullFlightDto.getFlightStatus().getId().equals(FlightStatusEnum.PREPARED.getId()))
            throw new FlightIsNotInPreparedStatusException();

        FullCrewDto fullCrewDto = new FullCrewDto();
        fullCrewDto.setEmployee(fullEmployeeDto);
        fullCrewDto.setFlight(fullFlightDto);
        fullCrewDto.setRole(crewDto.role());

        return crewService.saveCrew(fullCrewDto);
    }
}
