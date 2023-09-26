package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullErrorDto;
import ru.itmo.highendsystem.model.entity.Error;

/**
 * Мапер для сущности ошикби
 */
@Mapper(componentModel = "spring")
public interface ErrorMapper {
    Error fullDtoToError(FullErrorDto fullErrorDto);
}
