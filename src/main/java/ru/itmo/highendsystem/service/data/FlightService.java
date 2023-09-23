package ru.itmo.highendsystem.service.data;

import ru.itmo.highendsystem.model.dto.full.FullFlightDto;

/**
 * Сервис для работы с сущностью полёта
 */
public interface FlightService {

    /**
     * Получение полёта по id
     * @param id идентификатор полёта
     * @return полное дто полёта
     */
    FullFlightDto getFlightById(Long id);
}
