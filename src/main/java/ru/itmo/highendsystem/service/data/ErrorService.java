package ru.itmo.highendsystem.service.data;

import ru.itmo.highendsystem.model.dto.full.FullErrorDto;

/**
 * Сервис для работы с сущностью ошибки
 */
public interface ErrorService {
    /**
     * Сохранение ошибки
     *
     * @param fullErrorDto полное дто ошибки
     */
    void saveError(FullErrorDto fullErrorDto);
}
