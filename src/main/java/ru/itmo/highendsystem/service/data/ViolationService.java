package ru.itmo.highendsystem.service.data;

import ru.itmo.highendsystem.model.dto.full.FullViolationDto;

/**
 * Сервис для работы с сущностью нарушения
 */
public interface ViolationService {

    /**
     * Сохраняет новое нарушение
     * @param violationDto полное дто нарушения
     */
    void saveViolation(FullViolationDto violationDto);
}
