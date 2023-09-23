package ru.itmo.highendsystem.service.data;

import ru.itmo.highendsystem.model.dto.full.FullCrewDto;

/**
 * Сервис для работы с сущностью экипажа
 */
public interface CrewService {

    /**
     * Сохранение экипажа
     * @param crewDto полное дто экипажа
     */
    Boolean saveCrew(FullCrewDto crewDto);
}
