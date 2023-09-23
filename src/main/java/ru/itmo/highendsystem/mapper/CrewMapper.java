package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.itmo.highendsystem.model.dto.full.FullCrewDto;
import ru.itmo.highendsystem.model.entity.Crew;

/**
 * Маппер экипажа судна
 */
@Mapper(componentModel = "spring", uses = {FlightMapper.class, EmployeeMapper.class})
public interface CrewMapper {

    @Mapping(source = "flight", target = "crewPk.flight")
    @Mapping(source = "employee", target = "crewPk.employee")
    Crew fullDtoToCrew(FullCrewDto fullCrewDto);
}
