package ru.itmo.highendsystem.service.business;

import ru.itmo.highendsystem.model.dto.partial.ShortTicketDto;

/**
 * Сервис для управления покупкой и ценами билетов
 */
public interface TicketOperationService {

    /**
     * Покупка билета пользователем
     * @param humanId идентификатор пользователя
     * @param ticket краткое дто билета с данными пользоателя
     * @return идентификатор купленного билета
     */
    Long buyTicket(Long humanId, ShortTicketDto ticket) throws Exception;

    /**
     * Назначение цены билетам на полет
     * @param flightId идентификатор полета
     * @return количество билетов, для которых изменена цена
     */
    Integer setCostOnTickets(Long flightId, Integer cost);
}
