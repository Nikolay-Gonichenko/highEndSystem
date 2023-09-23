package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullBannedListDto;
import ru.itmo.highendsystem.model.entity.BannedList;

/**
 * Мапер для работы с блокировкой пользователя
 */
@Mapper(componentModel = "spring", uses = {HumanMapper.class, BannedReasonMapper.class})
public interface BannedListMapper {
    BannedList fullDtoToBannedList(FullBannedListDto fullBannedListDto);
}
