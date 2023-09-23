package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullViolationTypeDto;
import ru.itmo.highendsystem.model.entity.ViolationType;

/**
 * Маппер для работы с типами нарушений
 */
@Mapper(componentModel = "spring")
public interface ViolationTypeMapper {

    FullViolationTypeDto violationTypeToFullDto(ViolationType violationType);
}
