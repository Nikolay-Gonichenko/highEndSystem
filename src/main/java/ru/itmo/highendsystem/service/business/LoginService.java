package ru.itmo.highendsystem.service.business;

import ru.itmo.highendsystem.model.dto.partial.AccountDtoForLogin;

/**
 * Сервис для входа пользователя в систему
 */
public interface LoginService {

    /**
     * Вход в систему
     * @param accountDtoForLogin логин и пароль пользователя
     * @return токен
     */
    String login(AccountDtoForLogin accountDtoForLogin);
}
