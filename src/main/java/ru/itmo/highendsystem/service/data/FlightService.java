package ru.itmo.highendsystem.service.data;

import ru.itmo.highendsystem.model.dto.full.FullFlightDto;

import java.util.List;

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

    /**
     * Получение всех полетов
     * @param offset номер страницы
     * @param limit количество полётов на странице
     * @return список дто полетов
     */
    List<FullFlightDto> getAllFlights(Integer offset, Integer limit);

    FullFlightDto saveFlight(FullFlightDto flight);
}
