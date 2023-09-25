package ru.itmo.highendsystem.mapper;

import org.mapstruct.Mapper;
import ru.itmo.highendsystem.model.dto.full.FullRouteDto;
import ru.itmo.highendsystem.model.entity.Route;

/**
 * Маппер маршрута
 */
@Mapper(componentModel = "spring", uses = {LocationMapper.class})
public interface RouteMapper {
    FullRouteDto routeToFullDto(Route route);
}
