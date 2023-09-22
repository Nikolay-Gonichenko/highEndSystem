package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullHumanDto;
import ru.itmo.highendsystem.model.entity.Human;

/**
 * Маппер человека
 */
@Mapper(componentModel = "spring", uses = {DocumentMapper.class})
public interface HumanMapper {
    FullHumanDto humanToFullDto(Human human);
}
