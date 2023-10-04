package ru.itmo.highendsystem.model.dto.partial;

import jakarta.validation.constraints.NotNull;

/**
 * Дто для покупки билета
 */
public record BuyingTicketDto(
        @NotNull(message = "ИД человека не должен быть пустым") Long humanId,
        @NotNull(message = "Билет не должен быть пустым") ShortTicketDto ticketDto) {
}
