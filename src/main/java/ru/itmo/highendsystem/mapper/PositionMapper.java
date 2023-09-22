package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullPositionDto;
import ru.itmo.highendsystem.model.entity.Position;

/**
 * Маппер для должности работника
 */
@Mapper(componentModel = "spring", uses = {DepartmentMapper.class})
public interface PositionMapper {
    FullPositionDto positionToFullDto(Position position);
}
