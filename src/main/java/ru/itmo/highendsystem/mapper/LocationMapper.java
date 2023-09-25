package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullLocationDto;
import ru.itmo.highendsystem.model.entity.Location;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    FullLocationDto locationToFullDto(Location location);
}
