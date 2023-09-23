package ru.itmo.highendsystem.service.data;

import ru.itmo.highendsystem.model.dto.full.FullBannedListDto;

/**
 * Сервис для работы с сущностью блокировки пользователя
 */
public interface BannedListService {

    /**
     * Сохраняет сущностью блокировки пользователя
     * @param bannedListDto полное дто блокировки пользователя
     * @return true если операция завершилась успешно
     */
    Boolean saveBannedList(FullBannedListDto bannedListDto);
}
