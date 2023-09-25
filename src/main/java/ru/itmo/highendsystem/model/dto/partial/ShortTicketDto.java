package ru.itmo.highendsystem.model.dto.partial;

import ru.itmo.highendsystem.model.dto.full.FullFlightDto;

/**
 * Дто билета
 */
public record ShortTicketDto(Long flight, Integer cost, String place) {

}
