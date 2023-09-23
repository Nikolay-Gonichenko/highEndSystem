package ru.itmo.highendsystem.service.business;

import ru.itmo.highendsystem.model.dto.partial.ShortCrewDto;

/**
 * Сервис для работы с экипажем судна
 */
public interface CrewManagementService {

    /**
     * Добавление работника на рейс
     * @param crewDto краткое дто
     * @return true если операция завершилась успешно
     */
    Boolean addEmployeeToFlight(ShortCrewDto crewDto);
}
