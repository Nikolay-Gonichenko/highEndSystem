package ru.itmo.highendsystem.model.dto.partial;

/**
 * Дто для покупки билета
 */
public record BuyingTicketDto(Long humanId, ShortTicketDto ticketDto) {
}
