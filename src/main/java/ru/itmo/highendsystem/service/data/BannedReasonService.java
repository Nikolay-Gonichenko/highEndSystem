package ru.itmo.highendsystem.service.data;

import ru.itmo.highendsystem.model.dto.full.FullBannedReasonDto;

/**
 * Сервис для работы с сущностью "Причина блокировки пользователя"
 */
public interface BannedReasonService {
    /**
     * Получение причины блокировк по id
     * @param id идентификатор причины блокировки
     * @return полное дто причины блокировки
     */
    FullBannedReasonDto getBannedReasonById(Long id);
}
