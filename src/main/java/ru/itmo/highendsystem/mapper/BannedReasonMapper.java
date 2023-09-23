package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullBannedReasonDto;
import ru.itmo.highendsystem.model.entity.BannedReason;

/**
 * Маппер причины блокировки пользователя
 */
@Mapper(componentModel = "spring")
public interface BannedReasonMapper {
    FullBannedReasonDto bannedReasonToFullDto(BannedReason bannedReason);
}
