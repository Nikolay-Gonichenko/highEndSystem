package ru.itmo.highendsystem.service.data;

import ru.itmo.highendsystem.model.dto.full.FullEmployeeDto;

/**
 * Сервис для работы с сущностью Работник
 */
public interface EmployeeService {
    /**
     * Создание работника
     * @param employeeDto полное дто работника
     * @return true если работник создан
     */
    boolean saveEmployee(FullEmployeeDto employeeDto);

    /**
     * Получение работника по id
     * @param id идентификатор работника
     * @return полное дто работника
     */
    FullEmployeeDto getById(Long id);
}
