package ru.itmo.highendsystem.service.business;

import ru.itmo.highendsystem.model.dto.partial.ShortAccountDto;
import ru.itmo.highendsystem.model.dto.partial.ShortEmployeeDto;
import ru.itmo.highendsystem.model.dto.partial.ShortFlightDto;

/**
 * Сервис по созданию различных сущностей
 */
public interface CreateService {

    /**
     * Создание работника
     * @param employee дто работника
     * @return true если операция завершилась успешно
     */
    boolean createEmployee(ShortEmployeeDto employee);

    /**
     * Создание аккаунта
     * @param account дто аккаунта без id
     * @return иденфикатор аккаунта
     */
    Long createAccount(ShortAccountDto account);

    /**
     * Создание полёта
     * @param flight дто полёта с id параметров
     * @return идентификатор полёта
     */
    Long createFlight(ShortFlightDto flight);
}
