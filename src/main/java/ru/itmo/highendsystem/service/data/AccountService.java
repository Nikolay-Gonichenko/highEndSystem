package ru.itmo.highendsystem.service.data;

import ru.itmo.highendsystem.model.dto.full.FullAccountDto;

/**
 * Сервис для работы с сущностью аккаунта
 */
public interface AccountService {

    /**
     * Получение аккаунта по id
     * @param id идентификатор аккаунта
     * @return дто аккаунта
     */
    FullAccountDto getAccountById(Long id);

    /**
     * Сохраняет новый аккаунт
     * @param account полное дто аккаунта
     * @return полное дто аккаунта с id
     */
    FullAccountDto saveAccount(FullAccountDto account);

}
