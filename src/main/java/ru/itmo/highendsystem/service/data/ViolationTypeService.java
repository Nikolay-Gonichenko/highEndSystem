package ru.itmo.highendsystem.service.data;

import ru.itmo.highendsystem.model.dto.full.FullViolationTypeDto;

/**
 * Сервис для работы с сущностью типа нарушения
 */
public interface ViolationTypeService {

    /**
     * Получение типа нарушения по id
     * @param id идентификатор типа нарушения
     * @return полное дто типа нарушения
     */
    FullViolationTypeDto getViolationTypeById(Long id);
}
