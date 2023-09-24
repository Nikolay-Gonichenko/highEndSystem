package ru.itmo.highendsystem.service.data;


import ru.itmo.highendsystem.model.dto.full.FullTicketDto;

import java.util.List;

/***
 * Сервис для работы с сущностью билета
 */


public interface TicketService {

    /**
     * Получение всех билетов пользователя по id
     * @param id идентификатор аккаунта
     * @return Списко дто билетов
     */
    List<FullTicketDto> getAllTicketByUserId(long id);
}
