package ru.itmo.highendsystem.service.data;

import ru.itmo.highendsystem.model.dto.full.FullRouteDto;

/**
 * Сервис для работы с сущностью маршрута
 */
public interface RouteService {

    /**
     * Получение маршрута по его id
     * @param id идентификатор маршрута
     * @return полное дто маршрута
     */
    FullRouteDto getRouteById(Long id);
}
