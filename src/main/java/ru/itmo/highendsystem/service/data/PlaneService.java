package ru.itmo.highendsystem.service.data;

import ru.itmo.highendsystem.model.dto.full.FullPlaneDto;

/**
 * Сервис для работы с сущностью самолета
 */
public interface PlaneService {

    /**
     * Получение дто самолета по id
     * @param id идентификатор самолета
     * @return дто самолета
     */
    FullPlaneDto getPlaneById(Long id);
}
