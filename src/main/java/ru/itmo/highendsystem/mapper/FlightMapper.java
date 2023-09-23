package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullFlightDto;
import ru.itmo.highendsystem.model.entity.Flight;

/**
 * Маппер полётов
 */
@Mapper(componentModel = "spring")
public interface FlightMapper {
    FullFlightDto flightToFullDto(Flight flight);
}
