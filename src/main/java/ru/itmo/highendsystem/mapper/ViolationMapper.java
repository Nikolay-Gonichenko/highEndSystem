package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullViolationDto;
import ru.itmo.highendsystem.model.entity.Violation;

/**
 * Маппер для работы с нарушениями пользователей
 */
@Mapper(componentModel = "spring", uses = {AccountMapper.class})
public interface ViolationMapper {

    Violation fullDtoToViolation(FullViolationDto fullViolationDto);
}
