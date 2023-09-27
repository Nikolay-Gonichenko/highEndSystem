package ru.itmo.highendsystem.service.business;

import ru.itmo.highendsystem.model.dto.full.FullFlightDto;
import ru.itmo.highendsystem.model.dto.full.FullFlightSearchDto;

import java.util.List;

/**
 * Сервис для поиска полетов по фильтрам
 */
public interface FlightSearchService {

    /**
     * Получение всех полетов по фильтрам
     * @param search дто фильтров поиска
     * @return список полетов удовлетворяющих фильтрам
     */
    List<FullFlightDto> getFlightsByFilters(FullFlightSearchDto search);
}
