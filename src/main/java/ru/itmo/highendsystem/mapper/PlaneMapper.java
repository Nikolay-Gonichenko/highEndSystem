package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullPlaneDto;
import ru.itmo.highendsystem.model.entity.Plane;

/**
 * Маппер самолета
 */
@Mapper(componentModel = "spring")
public interface PlaneMapper {
    FullPlaneDto planeToFullDto(Plane plane);
}
