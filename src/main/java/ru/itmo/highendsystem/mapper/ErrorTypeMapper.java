package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullErrorTypeDto;
import ru.itmo.highendsystem.model.entity.ErrorType;

/**
 * Мапер типа ошибки
 */
@Mapper(componentModel = "spring")
public interface ErrorTypeMapper {
    FullErrorTypeDto errorTypeToFullDto(ErrorType errorType);
}
