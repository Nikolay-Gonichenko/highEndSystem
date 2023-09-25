package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullFlightStatusDto;
import ru.itmo.highendsystem.model.entity.FlightStatus;

/**
 * Маппер статуса полета
 */
@Mapper(componentModel = "spring")
public interface FlightStatusMapper {

    FullFlightStatusDto flightStatusToFullDto(FlightStatus flightStatus);
}
