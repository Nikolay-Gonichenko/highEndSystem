package ru.itmo.highendsystem.service.data;


import ru.itmo.highendsystem.model.dto.full.FullTicketDto;

import java.util.List;

/***
 * Сервис для работы с сущностью билета
 */


public interface TicketService {

    /**
     * Получение билета по его id
     * @param id идентификатор билета
     * @return полное дто бидета
     */
    FullTicketDto getTicketById(Long id);

    /**
     * Получение всех билетов пользователя по id
     * @param id идентификатор аккаунта
     * @return Списко дто билетов
     */
    List<FullTicketDto> getAllTicketsByUserId(Long id);

    /**
     * Получение всех билетов на определенный полет
     * @param id идентификатор полета
     * @return список билетов
     */
    List<FullTicketDto> getAllTicketsByFlightId(Long id);

    /**
     * Сохранение билета в бд
     * @param ticket дто билета
     * @return сохрененное дто билета
     */
    FullTicketDto saveTicket(FullTicketDto ticket);

    /**
     * Сохранение списка билетов
     * @param tickets список дто билетов
     * @return количество сохраненных билетов
     */
    Integer saveAllTickets(List<FullTicketDto> tickets);
}
